package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Contains functionality that is only needed in autonomous mode.
 * This was done to keep the main TicondeRobot.java from becoming cluttered.
 *
 * Created by Sam B.
 * 1/7/2022
 */
public class AutonomousTicondeRobot extends TicondeRobot{
    private final double KI = 0.000005;
    private final double KP = 0.001;
    private final double KD = 0.1;
    private final int dT = 15; // in milliseconds


    public void runSpinner() {
        this.spinner.setPower(1);
        TicondeRobot.HaltAndCatchFire(6 * 1000);
        this.spinner.setPower(0);
    }

    public void goBackward() {
        // meaning the left wheels are reversed
        this.backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        this.frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        this.backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        this.frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void goForward() {
        // meaning the right wheels are reversed
        this.backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        this.frontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        this.backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        this.frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    private void setDriveTrainEncoderEndpoint(int pos) {
        this.backLeft.setTargetPosition(pos);
        this.backRight.setTargetPosition(pos);
        this.frontLeft.setTargetPosition(pos);
        this.frontRight.setTargetPosition(pos);
    }

    public void moveToPositionPID(int targetPos, Telemetry telemetry){
        // if targetPos is negative, we need to go backwards
        if (targetPos < 0) {
            targetPos = -targetPos;
            this.goBackward();
        }

        this.setDriveTrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.setDriveTrainEncoderEndpoint(targetPos);
        this.setDriveTrainMode(DcMotor.RunMode.RUN_TO_POSITION);

        double power, integral = 0, prevError = 0, derivative = 0, error = 0;

        while (this.isBusy()) {
            error = targetPos - this.getAveragePosition();
            integral = integral + error;
            derivative = error - prevError;
            prevError = error;
            power = error * KP + integral * KI + derivative * KD;

            MotorPower motorPower = new MotorPower(power, power, power, power);
            this.setMovement(motorPower);

            telemetry.addLine(motorPower.toString());
            telemetry.addLine(this.frontLeft.getCurrentPosition() + "");
            telemetry.update();
            TicondeRobot.HaltAndCatchFire(dT);
        }

        // now that we're done, set the robot to the default forward and stop
        this.goForward();
        this.setMovement(TicondeRobot.ALL_ZERO);
        telemetry.addLine(TicondeRobot.ALL_ZERO.toString());
        telemetry.addLine(this.frontLeft.getCurrentPosition() + "");
        telemetry.update();
    }

    public boolean isBusy() {
        return this.backLeft.isBusy() || this.backRight.isBusy()
                || this.frontLeft.isBusy() || this.frontRight.isBusy();
    }

    private double getAveragePosition() {
        int total = this.frontRight.getCurrentPosition() + this.frontLeft.getCurrentPosition()
                + this.backLeft.getCurrentPosition() + this.backRight.getCurrentPosition();
        return total / 4.0;
    }


}
