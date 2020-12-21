package org.firstinspires.ftc.teamcode.Autonomous;
// import lines were omitted. OnBotJava will add them automatically.

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous
public class MoveToLine extends LinearOpMode {
    DcMotor main2;

    //main 2 is front right and works
    //minor2 is front left and it works

    @Override
    public void runOpMode() {
        main2 = hardwareMap.get(DcMotor.class, "minor2");

        // Reset the encoder during initialization
        main2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        // Set the motor's target position to 300 ticks
        main2.setTargetPosition(300);

        // Switch to RUN_TO_POSITION mode
        main2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Start the motor moving by setting the max velocity to 200 ticks per second
        main2.setPower(200);

        // While the Op Mode is running, show the motor's status via telemetry
        while (opModeIsActive()) {
            telemetry.addData("velocity", main2.getPower());
            telemetry.addData("position", main2.getCurrentPosition());
            telemetry.addData("is at target", !main2.isBusy());
            telemetry.update();
        }
        main2.setPower(0);
    }
}