package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Autonomous(name = "shortMovement", group = "Concept")
//@Disabled
public class ShortMovement extends LinearOpMode {
    private Robot robot;
    private MecanumDrive mecanumDrive;
    private DcMotor shooter1;
    private DcMotor shooter2;




    @Override
    public void runOpMode() {
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();

        waitForStart();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        sleep(150);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,1);
<<<<<<< Updated upstream
        sleep(1000);
=======
        sleep(300);
>>>>>>> Stashed changes
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        sleep(3250);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),1,0);
        sleep(1500);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,1);
        sleep(300);
        this.mecanumDrive.stopMoving();

        sleep(250);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(),0,-1);
        sleep(750);
        this.mecanumDrive.stopMoving();

    }

}
