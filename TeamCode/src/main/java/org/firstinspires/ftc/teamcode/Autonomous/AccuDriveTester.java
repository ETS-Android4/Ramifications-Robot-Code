package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotplus.autonomous.AccuDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Autonomous(name = "accudrivetester", group = "Concept")
//@Disabled
public class AccuDriveTester extends LinearOpMode {
    private Robot robot;
    private MecanumDrive mecanumDrive;
    DcMotor main2;
    DcMotor minor2;




    @Override
    public void runOpMode() {
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();
        main2 = hardwareMap.get(DcMotor.class, "main2");
        minor2 = hardwareMap.get(DcMotor.class, "minor2");

        waitForStart();

        AccuDrive.RobotForward(3000, 1, this, mecanumDrive, main2, minor2);



    }

}
