package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "First Steps!", group = "Basic")
public class FirstSteps extends OpMode {
    private DcMotor backleft, backright, frontleft, frontright;

    @Override
    public void init() {
        this.backleft = hardwareMap.get(DcMotor.class, "backleft");
        this.backright = hardwareMap.get(DcMotor.class, "backright");
        this.backright.setPower(.5);
        this.backleft.setPower(.5);
    }

    @Override
    public void loop() {

    }
}