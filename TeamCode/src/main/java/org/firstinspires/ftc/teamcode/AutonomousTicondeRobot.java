package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Contains functionality that is only needed in autonomous mode.
 * This was done to keep the main TicondeRobot.java from becoming cluttered.
 */
public class AutonomousTicondeRobot extends TicondeRobot{
    private final double KI = .00005;
    private final double KP = .006;
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

    }

    public void goForward() {
        // meaning the right wheels are reversed
        this.backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        this.frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private void setDriveTrainEncoderEndpoint(int pos) {
        this.backLeft.setTargetPosition(pos);
        this.backRight.setTargetPosition(pos);
        this.frontLeft.setTargetPosition(pos);
        this.frontRight.setTargetPosition(pos);
    }

    public void moveToPositionPID(int targetPos){
        // if targetPos is negative, we need to go backwards
        if (targetPos < 0) {
            targetPos = -targetPos;
            this.goBackward();
        }

        this.setDriveTrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.setDriveTrainEncoderEndpoint(targetPos);
        this.setDriveTrainMode(DcMotor.RunMode.RUN_TO_POSITION);

        double power = 1;
        double integral = 0;

        while (this.isBusy()) {
            double error = targetPos - this.getAveragePosition();
            integral = integral + error;
            power = error * KI + integral * KI;

            MotorPower motorPower = new MotorPower(power, power, power, power);
            this.setMovement(motorPower);

            System.out.println("HEY" + motorPower.toString());
            TicondeRobot.HaltAndCatchFire(dT);
        }

        // now that we're done, set the robot to the default forward
        this.goForward();
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
