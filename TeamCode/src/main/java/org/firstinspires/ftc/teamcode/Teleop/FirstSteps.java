package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.micdsrobotics.robotplus.gamepadwrapper.Controller;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.TicondeRobot;

@TeleOp(name = "First Steps! V1", group = "Basic")
public class FirstSteps extends OpMode {
    private TicondeRobot robot = new TicondeRobot();


    @Override
    public void init() {
        this.robot.initHardware(hardwareMap);

    }

    @Override
    public void loop() {
        telemetry.update(); // Telemetry displayed at the bottom of the FTC app must be updated every loop

        // handle dpad movement - tank movement - ONLY PRESS ONE
        if (gamepad1.dpad_right) {
            robot.setSidewaysTankMovement(0.5);
        } else if (gamepad1.dpad_left) {
            robot.setSidewaysTankMovement(-0.5);
        } else if (gamepad1.dpad_down) {
            robot.setForwardMovement(-0.5);
        } else if (gamepad1.dpad_up) {
            robot.setForwardMovement(0.5);
        }

        if (gamepad1.right_stick_x != 0 && gamepad1.right_stick_y != 0){

        }
        telemetry.addData("x", gamepad1.right_stick_x);
        telemetry.addData("y", gamepad1.right_stick_x);
        // joystick movement


    }
}