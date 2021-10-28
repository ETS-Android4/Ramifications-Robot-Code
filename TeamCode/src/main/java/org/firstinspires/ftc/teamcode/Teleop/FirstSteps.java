package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.GertrudeV2;

@TeleOp(name = "First Steps!", group = "Basic")
public class FirstSteps extends OpMode {
    private GertrudeV2 robot = new GertrudeV2();

    @Override
    public void init() {
        this.robot.initHardware(hardwareMap);
        this.robot.setForwardPower(1.0);
    }

    @Override
    public void loop() {

    }
}