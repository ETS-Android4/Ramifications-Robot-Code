package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MicdsFtcSdk.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.MicdsFtcSdk.hardware.Robot;

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
        sleep(2000);
        this.mecanumDrive.stopMoving();

    }

}
