package org.firstinspires.ftc.teamcode.Autonomous.UnusedPrograms;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Disabled
@Deprecated


@Autonomous(name = "Encoder Test 2", group = "Concept")
public class EncoderTest2 extends LinearOpMode {
    private Robot robot;
    private DcMotorEx main1;

    @Override
    public void runOpMode() {
        this.robot = new Robot(hardwareMap);
        this.main1 = (DcMotorEx) hardwareMap.get(DcMotor.class, "main1");

        waitForStart();

        this.main1.setVelocity(2000);

        sleep (2000);

        this.main1.setVelocity(100);

        sleep(2000);

        this.main1.setVelocity(0);

        /*this.shooter1.setVelocity(motorVelocity);
        this.shooter2.setPower(0.75);//this.shooter2.setVelocity(motorVelocity*0.75);
        sleep(500);
        this.hopperpush.setPower(-0.5);
        sleep(3000);
        this.shooter1.setVelocity(0);
        this.shooter2.setPower(0);
        //this.shooter2.setVelocity(0);
        this.hopperpush.setPower(0);*/

    }
}
