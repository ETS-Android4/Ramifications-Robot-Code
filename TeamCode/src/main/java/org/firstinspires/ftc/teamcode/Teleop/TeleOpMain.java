package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.MotorPower;
import org.firstinspires.ftc.teamcode.TicondeRobot;

@TeleOp(name = "TeleOP Main V2", group = "Basic")
public class TeleOpMain extends OpMode {
    private TicondeRobot robot = new TicondeRobot();


    @Override
    public void init() {
        this.robot.initHardware(hardwareMap);
        //robot.intakeRotate.setPosition(0);
        //robot.outtakeRotate.setPosition(0);
    }

    @Override
    public void loop() {
        telemetry.update(); // Telemetry displayed at the bottom of the FTC app must be updated every loop

        // these two lines handle omnidirectional movement and report the motor values to telemetry
        MotorPower power = robot.move(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        telemetry.addLine(power.toString());

        //intake
        if (gamepad1.x) {


            if (robot.intakeRotate.getPosition() != 0) {
                robot.intakeRotate.setPosition(0);
            } else {
                robot.intakeRotate.setPosition(0.35);
            }
        }

        //intake spinner
        if ((gamepad1.left_trigger > 0) || (gamepad2.left_trigger > 0)) {
            robot.intakeSpinnerLeft.setPower(0.5);
            robot.intakeSpinnerRight.setPower(0.5);

        }

        //outtake
        if (gamepad1.y) {

            if (robot.outtakeRotate.getPosition() != -0.7) {
                robot.outtakeRotate.setPosition(-0.7);
            } else {
                robot.outtakeRotate.setPosition(0);
            }

        }

        //Outtake up
        if (gamepad1.dpad_up) {

            while (gamepad1.dpad_up) {
                robot.outtakeRaise.setPower(1);
                robot.outtakeLower.setPower(0);
            }
            robot.outtakeRaise.setPower(0);
            robot.outtakeLower.setPower(1);
            robot.HaltAndCatchFire(1);
            robot.outtakeLower.setPower(0);

        }
        //Outtake down
        if (gamepad1.dpad_down) {
            while (gamepad1.dpad_down) {
                robot.outtakeRaise.setPower(-1);
                robot.outtakeLower.setPower(1);
            }
            robot.outtakeLower.setPower(0);
            robot.outtakeRaise.setPower(1);
            robot.HaltAndCatchFire(50);
            robot.outtakeRaise.setPower(0);
        }


        //Carousel wheel
        if (gamepad1.right_trigger>0) {
            robot.spinner.setPower(gamepad1.right_trigger);
        }
    }

}