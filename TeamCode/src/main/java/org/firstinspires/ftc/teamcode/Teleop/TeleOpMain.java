package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MotorPower;
import org.firstinspires.ftc.teamcode.TicondeRobot;

/**
 * Our 2021-2022 Season TeleOp Code. See TicondeRobot.java for more.
 *
 */
@TeleOp(name = "TeleOP Main V2", group = "Basic")
public class TeleOpMain extends OpMode {
    private TicondeRobot robot = new TicondeRobot();
    private boolean isIntakeSpinning = false, isIntakeSamePress = false;
    private boolean isIntakeUp = true, isIntakeUpSamePress = true;

    private boolean isOuttakeUp = true, isOuttakeUpSamePress = true;



    @Override
    public void init() {
        this.robot.initHardware(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.update(); // Telemetry displayed at the bottom of the FTC app must be updated every loop

        // these two lines handle omnidirectional movement and report the motor values to telemetry
        MotorPower power = robot.move(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        telemetry.addLine(power.toString());

        //intake
        if (gamepad1.x || gamepad2.x) {
            if (!isIntakeUpSamePress) {
                isIntakeUp = !isIntakeUp;
            }
            isIntakeUpSamePress = true;
        } else {
            isIntakeUpSamePress = false;
        }

        if (!isIntakeUp) {
            robot.intakeRotate.setPosition(0.5);
        } else {
            robot.intakeRotate.setPosition(1);
        }

        //intake spinner
        if (gamepad1.left_trigger > 0 || gamepad2.left_trigger > 0) {
            if (!isIntakeSamePress) {
                isIntakeSpinning = !isIntakeSpinning;
                isIntakeSamePress = true;
            }
        } else {
            isIntakeSamePress = false;
        }

        if (isIntakeSpinning) {
            robot.intakeSpinnerRight.setPower(1);
            robot.intakeSpinnerLeft.setPower(-1);
        } else {
            robot.intakeSpinnerLeft.setPower(0);
            robot.intakeSpinnerRight.setPower(0);
        }

        //outtake
        if (gamepad1.y || gamepad2.y) {
            if (!isOuttakeUpSamePress) {
                isOuttakeUp = !isOuttakeUp;
                isOuttakeUpSamePress = true;
            }
        }  else {
            isOuttakeUpSamePress = false;
        }

        if (isOuttakeUp) {
            robot.outtakeRotate.setPosition(0.5);
        } else {
            robot.outtakeRotate.setPosition(0);
        }

        //Outtake up
        if (gamepad1.dpad_up || gamepad2.dpad_up) {

            while (gamepad1.dpad_up || gamepad2.dpad_up) {
                robot.outtakeRaise.setPower(1);
                robot.outtakeLower.setPower(0);
            }
            robot.outtakeRaise.setPower(0);
            robot.outtakeLower.setPower(1);
            robot.HaltAndCatchFire(1);
            robot.outtakeLower.setPower(0);

        }
        //Outtake down
        if (gamepad1.dpad_down || gamepad2.dpad_down) {
            while (gamepad1.dpad_down || gamepad2.dpad_down) {
                robot.outtakeRaise.setPower(-1);
                robot.outtakeLower.setPower(1);
            }
            robot.outtakeLower.setPower(0);
            robot.outtakeRaise.setPower(1);
            robot.HaltAndCatchFire(50);
            robot.outtakeRaise.setPower(0);
        }


        //Carousel wheel
        if (gamepad1.right_trigger > 0 || gamepad2.right_trigger > 0) {
            robot.spinner.setPower(1);
        } else if (gamepad1.right_bumper || gamepad2.right_bumper) {
            robot.spinner.setPower(-1);
        } else {
            robot.spinner.setPower(0);
        }
    }

}