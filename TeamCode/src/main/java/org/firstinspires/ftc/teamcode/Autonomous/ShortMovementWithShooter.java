package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Autonomous(name = "shortMovementWithShooter", group = "Concept")
//@Disabled
public class ShortMovementWithShooter extends LinearOpMode {
    private Robot robot;
    private MecanumDrive mecanumDrive;
    private DcMotorEx shooter1;
    private DcMotor shooter2;
    private CRServo hopperpush;
    private Servo claw;
    private DcMotor arm;

    @Override
    public void runOpMode() {
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();
        this.shooter1 = (DcMotorEx) hardwareMap.get(DcMotor.class, "shooter1");
        this.shooter2 = hardwareMap.get(DcMotor.class, "shooter2");
        this.hopperpush = hardwareMap.get(CRServo.class, "hopperpush");
        this.claw = hardwareMap.get(Servo.class, "claw");
        claw.setPosition(0.63);
        this.arm = hardwareMap.get(DcMotor.class, "arm");

        waitForStart();

        arm.setPower(0.45); // TODO: 2/11/2021 might need to reverse again
        claw.setPosition(0.63);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        sleep(1800);
        this.mecanumDrive.stopMoving();

        arm.setPower(0); // TODO: 2/11/2021 might need to reverse again

        this.shooter1.setVelocity(2050);
        this.shooter2.setPower(0.75);
        sleep(2500);
        this.hopperpush.setPower(-0.5);
        sleep(3000);
        this.shooter1.setVelocity(0);
        this.shooter2.setPower(0);
        this.hopperpush.setPower(0);
        claw.setPosition(0.63);

        arm.setPower(-0.25); // TODO: 2/11/2021 might need to reverse again
        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
        sleep(450);
        this.mecanumDrive.stopMoving();
        claw.setPosition(0.63);
        arm.setPower(0); // TODO: 2/11/2021 might need to reverse again

        /*this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,1);
        sleep(1000);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        sleep(1000);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),1,0);
        sleep(1750);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(),0,-1);
        sleep(750);
        this.mecanumDrive.stopMoving();*/

    }

}
