package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

import java.util.List;

@Autonomous(name = "movesquare", group = "Concept")
//@Disabled
public class MoveSquare extends LinearOpMode {
    private Robot robot;
    private MecanumDrive mecanumDrive;




    @Override
    public void runOpMode() {
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();

        waitForStart();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        sleep(500);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,1);
        sleep(600);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),1,0);
        sleep(500);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(),0,-1);
        sleep(600);

        this.mecanumDrive.stopMoving();

    }

}
