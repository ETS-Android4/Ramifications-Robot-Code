package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Autonomous(name = "Encoder Test", group = "Concept")
public class EncoderTest extends LinearOpMode {
    private Robot robot;
    private DcMotorEx shooter1;
    private DcMotor shooter2; //DcMotorEx
    private CRServo hopperpush;
    private int motorVelocity = 2200;

    @Override
    public void runOpMode() {
        this.robot = new Robot(hardwareMap);
        this.shooter1 = (DcMotorEx) hardwareMap.get(DcMotor.class, "shooter1");
        this.shooter1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.shooter2 = hardwareMap.get(DcMotor.class, "shooter2"); //(DcMotorEx)
        //this.shooter2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.hopperpush = hardwareMap.get(CRServo.class, "hopperpush");



        waitForStart();

        this.shooter1.setVelocity(motorVelocity);
        this.shooter2.setPower(0.75);//this.shooter2.setVelocity(motorVelocity*0.75);
        sleep(500);
        this.hopperpush.setPower(-0.5);
        sleep(3000);
        this.shooter1.setVelocity(0);
        this.shooter2.setPower(0);
        //this.shooter2.setVelocity(0);
        this.hopperpush.setPower(0);

    }
}
