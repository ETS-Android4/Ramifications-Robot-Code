package org.firstinspires.ftc.teamcode.Teleop;

import static java.lang.Thread.sleep;

import com.qualcomm.hardware.motors.RevRoboticsCoreHexMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;



import org.firstinspires.ftc.micdsrobotics.robotplus.gamepadwrapper.Controller;
import org.firstinspires.ftc.micdsrobotics.robotplus.hardware.Motor;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.MotorPower;
import org.firstinspires.ftc.teamcode.TicondeRobot;

@TeleOp(name = "TeleOP Main V2", group = "Basic")
public class TeleOpMain extends OpMode {
    private TicondeRobot robot = new TicondeRobot();
    private Servo intake;
    private Servo outtake;
    private DcMotor outtakeRaise;
    private DcMotor spinnyWheel;
    private double intakePosition;
    private double outtakePosition;
    private double outtakeRaisePosition;


    @Override
    public void init() {
        this.robot.initHardware(hardwareMap);
        this.intake = hardwareMap.get(Servo.class, "intake");
        this.outtake = hardwareMap.get(Servo.class, "outtake");
        this.outtakeRaise = hardwareMap.get(DcMotor.class, "outtakeRaise");
        this.spinnyWheel = hardwareMap.get(DcMotor.class, "spinnyWheel");
        intake.setPosition(0);
        outtake.setPosition(0);



    }

    @Override
    public void loop() {
        telemetry.update(); // Telemetry displayed at the bottom of the FTC app must be updated every loop

        // these two lines handle omnidirectional movement and report the motor values to telemetry
        MotorPower power = this.robot.move(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        telemetry.addLine(power.toString());

        //intake
        if (gamepad1.x) {
            intake.setPosition(1);
            while(intake.getPosition() != 1) {

            }
            intake.setPosition(0);
        }
        //outtake
        if (gamepad1.y) {
            outtake.setPosition(1);
            while(outtake.getPosition() != 1) {

            }
            outtake.setPosition(0);
        }
        //Outtake up
        if (gamepad1.dpad_up) {
            outtakeRaise.setPower(1);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Outtake down
        if (gamepad1.dpad_down) {
            outtakeRaise.setPower(-1);
            try{
                sleep(1000);
            } catch (InterruptedException f) {
                f.printStackTrace();
            }
        }
        //Carousel wheel
        if (gamepad1.right_trigger>0) {
            spinnyWheel.setPower(gamepad1.right_trigger);
        }
    }
}