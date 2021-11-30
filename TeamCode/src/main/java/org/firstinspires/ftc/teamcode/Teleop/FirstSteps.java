package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.micdsrobotics.robotplus.gamepadwrapper.Controller;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.TicondeRobot;

@TeleOp(name = "TeleOP Main V2", group = "Basic")
public class FirstSteps extends OpMode {
    private TicondeRobot robot = new TicondeRobot();


    @Override
    public void init() {
        this.robot.initHardware(hardwareMap);

    }

    @Override
    public void loop() {
        telemetry.update(); // Telemetry displayed at the bottom of the FTC app must be updated every loop

        this.robot.move(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }
}