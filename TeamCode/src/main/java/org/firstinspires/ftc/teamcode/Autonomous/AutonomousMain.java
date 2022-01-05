package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.MotorPower;
import org.firstinspires.ftc.teamcode.TicondeRobot;

@Autonomous(name = "Autonomous Simple V1 1", group = "Basic")
public class AutonomousMain extends LinearOpMode {
    private TicondeRobot robot = new TicondeRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.initHardware(hardwareMap);
        robot.setDriveTrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        robot.frontRight.setTargetPosition((int) Math.floor(-28*5));
        robot.frontLeft.setTargetPosition((int) Math.floor(-28*5));
        robot.backLeft.setTargetPosition((int) Math.floor(-28*5));
        robot.backRight.setTargetPosition((int) Math.floor(-28*5));
        robot.setDriveTrainMode(DcMotor.RunMode.RUN_TO_POSITION);;

        waitForStart();

        MotorPower power = new MotorPower(.1, .1,.1, .1);
        robot.setMovement(power);

        long oldTime = System.currentTimeMillis();
        while (robot.frontLeft.isBusy() || robot.frontRight.isBusy() || robot.backRight.isBusy() || robot.backLeft.isBusy() || opModeIsActive()) {
            int error = (-28 * 5) - robot.frontRight.getCurrentPosition();
            final double kP = .01;
            final int newPowerInt = (int) Math.floor(error * kP);
            MotorPower newPower = new MotorPower(newPowerInt, newPowerInt,newPowerInt, newPowerInt);
            robot.setMovement(newPower);

            System.out.println("HEY!" + error + " " + error * kP);
        }


        robot.spinner.setPower(1);

        TicondeRobot.HaltAndCatchFire(6* 1000);

        robot.spinner.setPower(0);
    }
}
