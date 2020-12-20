package org.firstinspires.ftc.teamcode.Autonomous;
// import lines were omitted. OnBotJava will add them automatically.

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous
public class MoveToLine extends LinearOpMode {
    DcMotor main1;

    @Override
    public void runOpMode() {
        main1 = hardwareMap.get(DcMotor.class, "main1");

        // Reset the encoder during initialization
        main1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        // Set the motor's target position to 300 ticks
        main1.setTargetPosition(300);

        // Switch to RUN_TO_POSITION mode
        main1.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Start the motor moving by setting the max velocity to 200 ticks per second
        main1.setPower(200);

        // While the Op Mode is running, show the motor's status via telemetry
        while (opModeIsActive()) {
            telemetry.addData("velocity", main1.getPower());
            telemetry.addData("position", main1.getCurrentPosition());
            telemetry.addData("is at target", !main1.isBusy());
            telemetry.update();
        }
        main1.setPower(0);
    }
}