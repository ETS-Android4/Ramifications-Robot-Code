package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Autonomous(name = "AccuDrive Setup", group = "Concept")
//@Disabled
public class AccuDriveSetup extends LinearOpMode {
    private Robot robot;
    private MecanumDrive mecanumDrive;


    // to use accurdive, you have to declare the encodervalues
    private DcMotor main1;
    private DcMotor main2;
    private DcMotor minor1;
    private DcMotor minor2;






    @Override
    public void runOpMode() {
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();

        this.main1 =  hardwareMap.get(DcMotor.class, "main1");
        this.main2 =  hardwareMap.get(DcMotor.class, "main2");
        this.minor1 = hardwareMap.get(DcMotor.class, "minor1");
        this.minor2 = hardwareMap.get(DcMotor.class, "minor2");


        //to use accudrive, you have to set up the four hardwaredevices


        waitForStart();

        AccuDrive.Forward(this,  robot,  main1,  main2,  minor1,  minor2 ,  30,  1);

        AccuDrive.Right(this,  robot,  main1,  main2,  minor1,  minor2 ,  30,  1);

        AccuDrive.Backward(this,  robot,  main1,  main2,  minor1,  minor2 ,  30,  1);

        AccuDrive.Left(this,  robot,  main1,  main2,  minor1,  minor2 ,  30,  1);

        AccuDrive.TurnLeft(this,  robot,  main1,  main2,  minor1,  minor2 ,  30,  1);

        AccuDrive.TurnRight(this,  robot,  main1,  main2,  minor1,  minor2 ,  30,  1);

        telemetry.addLine("finished stuff");
        telemetry.update();
        sleep(4000);
        telemetry.addLine("done");
        telemetry.update();



    }

}
