package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MotorPower;
import org.firstinspires.ftc.teamcode.TicondeRobot;
import org.firstinspires.ftc.teamcode.Toggler;

/**
 * Our 2021-2022 Season TeleOp Code. See TicondeRobot.java for more.
 */
@TeleOp(name = "TeleOP Main V2", group = "Basic")
public class TeleOpMain extends OpMode {
    private TicondeRobot robot = new TicondeRobot();
    private Toggler toggleIntake, toggleOuttake, toggleIntakeSpinner;

    private boolean wasOuttakeMoving = false;

    @Override
    public void init() {
        this.robot.initHardware(hardwareMap);

        //intake spinner
        toggleIntakeSpinner = new Toggler(false, (isOn) -> {
            if (isOn) {
                robot.intakeSpinnerRight.setPower(1);
                robot.intakeSpinnerLeft.setPower(-1);
            } else if (gamepad1.left_bumper || gamepad2.left_bumper) {
                robot.intakeSpinnerRight.setPower(-1);
                robot.intakeSpinnerLeft.setPower(1);
            } else {
                robot.intakeSpinnerLeft.setPower(0);
                robot.intakeSpinnerRight.setPower(0);
            }
        });

        //intake
        toggleIntake = new Toggler(true, (isOn) -> {
            if (!isOn) {
                robot.intakeRotate.setPosition(0.5);
            } else {
                if (robot.outtakeRotate.getPosition() == 0.5) {
                    robot.intakeRotate.setPosition(1);
                }
            }
        });

        //outtake
        toggleOuttake = new Toggler(true, (isOn) -> {
            if (isOn) {
                robot.outtakeRotate.setPosition(0.5);
            } else {
                robot.outtakeRotate.setPosition(0);
            }
        });
    }

    @Override
    public void loop() {
        telemetry.update(); // Telemetry displayed at the bottom of the FTC app must be updated every loop

        // these two lines handle omnidirectional~ movement and report the motor values to telemetry
        MotorPower power = robot.move(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        telemetry.addLine(power.toString());

        toggleIntake.checkAndRun(gamepad1.x || gamepad2.x);

        toggleIntakeSpinner.checkAndRun(gamepad1.left_trigger > 0 || gamepad2.left_trigger > 0);

        toggleOuttake.checkAndRun(gamepad1.y || gamepad2.y);

        //Outtake up
        if (gamepad1.dpad_up || gamepad2.dpad_up) {
            wasOuttakeMoving = true;
            robot.outtakeRaise.setPower(1);
            robot.outtakeLower.setPower(0);
        } else if (wasOuttakeMoving) {
            wasOuttakeMoving = false;
            robot.outtakeRaise.setPower(0);
            robot.outtakeLower.setPower(1);
            robot.HaltAndCatchFire(50);
            robot.outtakeLower.setPower(0);
        }

        //Outtake down - make sure you don't press up as well
        if (gamepad1.dpad_down || gamepad2.dpad_down && !(gamepad1.dpad_up || gamepad2.dpad_up)) {
            wasOuttakeMoving = true;
            robot.outtakeRaise.setPower(-1);
            robot.outtakeLower.setPower(1);
        } else if (wasOuttakeMoving) {
            wasOuttakeMoving = false;
            robot.outtakeLower.setPower(0);
            robot.outtakeRaise.setPower(1);
            robot.HaltAndCatchFire(50);
            robot.outtakeRaise.setPower(0);
        }


        //Carousel wheel
        if (gamepad1.right_trigger > 0 || gamepad2.right_trigger > 0) {
            robot.spinner.setPower(0.25);
        } else if (gamepad1.right_bumper || gamepad2.right_bumper) {
            robot.spinner.setPower(-0.25);
        } else {
            robot.spinner.setPower(0);
        }
    }

}