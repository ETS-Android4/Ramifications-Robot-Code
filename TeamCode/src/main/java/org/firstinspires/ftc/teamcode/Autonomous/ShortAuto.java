package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Autonomous(name = "shortMovementWithShooter", group = "Concept")
//@Disabled
public class ShortMovementWithShooter extends LinearOpMode {
    private Robot robot;
    private MecanumDrive mecanumDrive;
    private DcMotor shooter1;
    private DcMotor shooter2;
    private CRServo hopperpush;

    @Override
    public void runOpMode() {
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();
        this.shooter1 = hardwareMap.get(DcMotor.class, "shooter1");
        this.shooter2 = hardwareMap.get(DcMotor.class, "shooter2");
        this.hopperpush = hardwareMap.get(CRServo.class, "hopperpush");

        waitForStart();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        sleep(1900);
        this.mecanumDrive.stopMoving();

        this.shooter1.setPower(1.0);
        this.shooter2.setPower(0.75);
        sleep(500);
        this.hopperpush.setPower(-0.5);
        sleep(3000);
        this.shooter1.setPower(0);
        this.shooter2.setPower(0);
        this.hopperpush.setPower(0);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
        sleep(300);
        this.mecanumDrive.stopMoving();

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
