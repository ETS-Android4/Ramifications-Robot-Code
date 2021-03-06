package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;


@Autonomous(name = "AccuDrive Setup (ANROID STUDIO version)", group = "Concept")

public class AccuDriveSetup extends LinearOpMode {




    // to use accurdive, you have to declare the encodervalues
    private DcMotor main1;
    private DcMotor main2;
    private DcMotor minor1;
    private DcMotor minor2;






    @Override
    public void runOpMode() {


        this.main1 =  hardwareMap.get(DcMotor.class, "main1");
        this.main2 =  hardwareMap.get(DcMotor.class, "main2");
        this.minor1 = hardwareMap.get(DcMotor.class, "minor1");
        this.minor2 = hardwareMap.get(DcMotor.class, "minor2");


        //to use accudrive, you have to set up the four hardwaredevices


        waitForStart();

<<<<<<< HEAD
        //AccuDrive.Forward(this, main1,  main2,  minor1,  minor2 ,  5,  1);

        //AccuDrive.Left(this, main1,  main2,  minor1,  minor2 ,  50,  1);

        AccuDrive.Forward(this, main1,  main2,  minor1,  minor2 ,  50,  1);
        AccuDrive.Right(this, main1,  main2,  minor1,  minor2 ,  50,  0.5);
        AccuDrive.Backward(this, main1,  main2,  minor1,  minor2 ,  50,  0.75);
        AccuDrive.Left(this, main1,  main2,  minor1,  minor2 ,  50,  0.25);
=======
        /*AccuDrive.Forward(this,  robot,  main1,  main2,  minor1,  minor2 ,  44,  1);
>>>>>>> master

        AccuDrive.Right(this,  robot,  main1,  main2,  minor1,  minor2 ,  100,  1);

        AccuDrive.Backward(this,  robot,  main1,  main2,  minor1,  minor2 ,  30,  1);*/

        AccuDrive.Left(this,  robot,  main1,  main2,  minor1,  minor2 ,  30,  1);

        /*AccuDrive.TurnLeft(this,  robot,  main1,  main2,  minor1,  minor2 ,  30,  1);

        AccuDrive.TurnRight(this,  robot,  main1,  main2,  minor1,  minor2 ,  30,  1);*/




    }

}
