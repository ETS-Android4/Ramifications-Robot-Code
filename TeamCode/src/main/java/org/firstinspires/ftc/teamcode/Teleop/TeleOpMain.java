package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.MotorPower;
import org.firstinspires.ftc.teamcode.TicondeRobot;

@TeleOp(name = "TeleOP Main V2", group = "Basic")
public class TeleOpMain extends OpMode {
    private TicondeRobot robot = new TicondeRobot();
    private int outtakeRaisePosition = 0;


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
            robot.intakeRotate.setPosition(1);
            while(robot.intakeRotate.getPosition() != 1) {

            }
            robot.intakeRotate.setPosition(0);
        }


        //intake spinner
        if (gamepad1.left_trigger > 0) {
            robot.intakeSpinnerLeft.setPower(0.5);
            robot.intakeSpinnerRight.setPower(0.5);

        }

        //outtake
        if (gamepad1.y) {
            robot.outtakeRotate.setPosition(1);
            while(robot.outtakeRotate.getPosition() != 1) {

            }
            robot.outtakeRotate.setPosition(0);
        }
        /*
        //Outtake up
        if (gamepad1.dpad_up || outtakeRaisePosition != 2) {
            robot.outtakeRaise.setPower(1);
            robot.outtakeLower.setPower(-1);

            robot.HaltAndCatchFire(500);
            robot.outtakeRaise.setPower(0);
            robot.outtakeLower.setPower(0);
            outtakeRaisePosition ++;
        }
        //Outtake down
        if (gamepad1.dpad_down || outtakeRaisePosition != 0) {
            robot.outtakeRaise.setPower(-1);
            robot.outtakeLower.setPower(1);
            robot.HaltAndCatchFire(500);
            robot.outtakeRaise.setPower(0);
            robot.outtakeLower.setPower(0);
            outtakeRaisePosition --;
        }

         */
        //Carousel wheel
        if (gamepad1.right_trigger>0) {
            robot.spinner.setPower(gamepad1.right_trigger);
        }
    }

}