package org.firstinspires.ftc.teamcode.Autonomous;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Autonomous(name = "MoveToLine", group = "Generic")
public class MoveToLine extends LinearOpMode {

    private Robot robot;
    private MecanumDrive mecanumDrive;
    int step = 0;




    public void runOpMode() {
        // init
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();


        // set motors to coast
        this.mecanumDrive.getMajorDiagonal().getMotor1().setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.mecanumDrive.getMajorDiagonal().getMotor2().setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.mecanumDrive.getMinorDiagonal().getMotor1().setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.mecanumDrive.getMinorDiagonal().getMotor2().setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        waitForStart();


        while (opModeIsActive()) {
            // update colors


            telemetry.update();

            switch (step) {

                case 0:
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),1,0);
                    sleep(2300);
                    this.mecanumDrive.stopMoving();
                    step++;
                    break;

            }
        }
    }
}
