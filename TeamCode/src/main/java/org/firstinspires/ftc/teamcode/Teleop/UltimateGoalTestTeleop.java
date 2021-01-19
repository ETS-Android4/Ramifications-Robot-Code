package org.firstinspires.ftc.teamcode.Teleop;//package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
//import org.firstinspires.ftc.teamcode.lib.AutonomousConstants;
//import org.firstinspires.ftc.teamcode.lib.ClampState;
//import org.firstinspires.ftc.teamcode.lib.GrabberState;
//import org.firstinspires.ftc.teamcode.lib.TeleOpConstants;
//import org.firstinspires.ftc.teamcode.lib.perceptron.CollisionExecutor;
import org.firstinspires.ftc.teamcode.RapidFire;
import org.firstinspires.ftc.teamcode.robotplus.hardware.IMUWrapper;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MotorPair;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@TeleOp(name = "Ultimate Goal Teleop V:3.0", group = "Basic")
public class UltimateGoalTestTeleop extends OpMode {
    private Robot robot;
    private MecanumDrive mecanumDrive;
    private DcMotor shooter1;
    private DcMotor shooter2;
    double firepower = 0.5;
    private DcMotor arm;
    private Servo claw;
    boolean clawstate = false;
    boolean hopstate = false;
    double firepowerstate = 0.0;
    private DcMotor intake;
    private Servo hopperpush;
    //private MotorPair intake;
    //private DcMotor arm;
    //private DcMotor elevator;

    //private Servo grabber;
    //private Servo assist;
    //private Servo clampLeft;
    //private Servo clampRight;
    //private GrabberState grabberState = GrabberState.CLOSED;
    //private ClampState clampState = ClampState.UP;
    //private IntegratingGyroscope gyro;
    //private ModernRoboticsI2cGyro modernRoboticsI2cGyro;
    //private AngularVelocity rates;
    //private IMUWrapper imuWrapper;

    @Override
    public void init() {

        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();
        this.shooter1 = hardwareMap.get(DcMotor.class, "shooter1");
        this.shooter2 = hardwareMap.get(DcMotor.class, "shooter2");
        this.arm = hardwareMap.get(DcMotor.class, "arm");
        this.claw = hardwareMap.get(Servo.class, "claw");
        claw.setPosition(0);
        this.hopperpush = hardwareMap.get(Servo.class, "hopperpush");
        this.intake = hardwareMap.get(DcMotor.class, "intake");
        hopperpush.setPosition(0.5);

        //this.intake = new MotorPair(hardwareMap, "intake1", "intake2");
        //this.arm = hardwareMap.get(DcMotor.class, "arm");
        //this.elevator = hardwareMap.get(DcMotor.class, "elevator");
        //this.grabber = hardwareMap.get(Servo.class, "grabber");
        //this.assist = hardwareMap.get(Servo.class, "assist");
        //this.clampLeft = hardwareMap.get(Servo.class, "clamp_left");
        //this.clampRight = hardwareMap.get(Servo.class, "clamp_right");
        //this.modernRoboticsI2cGyro = hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");
        //this.imuWrapper = new IMUWrapper(hardwareMap);
        /*this.gyro = (IntegratingGyroscope) modernRoboticsI2cGyro;
        modernRoboticsI2cGyro.calibrate();*/

        //this.elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //this.arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private double computeMovement(double x) {
        if (gamepad1.right_trigger == 0) {
            if (x == 0.0) {
                return 0.0;
            } else if (x > 0.0) {
                return Math.pow(100, (1.02 * x) - 1.07) + 0.2;
            } else if (x < 0.0) {
                return -(Math.pow(100, (-1.02 * x) - 1.07) + 0.2);
            }
            return 0.0;
        } else if (gamepad1.right_trigger == 1) {
            if (x == 0.0) {
                return 0.0;
            } else if (x > 0.0) {
                return Math.pow(100, (0.87 * x) - 1.07) + 0.4;
            } else if (x < 0.0) {
                return -(Math.pow(100, (-0.87 * x) - 1.07) + 0.4);
            }
            return 0.0;
        }
        return 0.0;
    }

    @Override
    public void loop() {

        //rates = gyro.getAngularVelocity(AngleUnit.DEGREES.DEGREES);
        //telemetry.addData("isGrabberOpen", this.grabberState);
        //telemetry.addData("Collision Detected", CollisionExecutor.calculate(modernRoboticsI2cGyro.getHeading(), this.imuWrapper));
        telemetry.update();


        // check for collision. If collided, stop to prevent further damage
        /*if (CollisionExecutor.calculate(modernRoboticsI2cGyro.getHeading(), this.imuWrapper)) {
            this.mecanumDrive.stopMoving();
         */

        if (gamepad1.x) {
            intake.setPower(-1);
            telemetry.addLine("intake active");
        } else if (gamepad1.y) {
            intake.setPower(1);
            telemetry.addLine("reversing intake");
        } else {
            intake.setPower(0);
            telemetry.addLine("intake off");
        }


        if (gamepad1.b) {
            if (firepowerstate == 0) {
                telemetry.addLine("single shot mode activated");
                shooter2.setPower(1);
                firepowerstate = 0.7;
                shooter1.setPower(firepowerstate);
                try {
                    Thread.sleep(200);
                } catch (Exception e) {

                }
            } else if (firepowerstate == 0.70) {
                telemetry.addLine("burst mode activate");
                shooter2.setPower(1);
                firepowerstate = 0.75;
                shooter1.setPower(firepowerstate);
                try {
                    Thread.sleep(200);
                } catch (Exception e) {

                }
            } else if (firepowerstate == 0.75) {
                telemetry.addLine("yeeter shut down");
                shooter2.setPower(0);
                firepowerstate = 0.0;
                shooter1.setPower(firepowerstate);
                try {
                    Thread.sleep(200);
                } catch (Exception e) {

                }
            }
        }


        //control over drivetrain
        this.mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);


        if(gamepad1.right_trigger > 0){
            RapidFire.rapidFire(mecanumDrive,shooter1,shooter2,hopperpush,gamepad1,telemetry);
        }


        //open or close claw on wobble goal arm
        arm.setPower(-gamepad2.right_stick_y);

        //wobble goal claw
        if (gamepad2.a) {
            if (clawstate == false) {
                telemetry.addLine("Wobble Claw Opening");
                claw.setPosition(1);
                clawstate = true;
                try {
                    Thread.sleep(150);
                } catch (Exception e) {

                }
            } else if (clawstate == true) {
                telemetry.addLine("Wobble Claw Closing");
                claw.setPosition(0);
                clawstate = false;
                try {
                    Thread.sleep(150);
                } catch (Exception e) {

                }

            }
        }

        //hopper pusher
        if (gamepad1.a) {
            if (hopstate == false) {
                telemetry.addLine("Hopper pusher Opening");
                hopperpush.setPosition(1);
                hopstate = true;
                try {
                    Thread.sleep(150);
                } catch (Exception e) {

                }
            } else if (hopstate == true) {
                telemetry.addLine("Hopper Pusher Closing");
                hopperpush.setPosition(0);
                hopstate = false;
                try {
                    Thread.sleep(150);
                } catch (Exception e) {

                }

            }
        }
    }






        /*
        // assist
        this.assist.setPosition((gamepad1.right_bumper || gamepad2.right_bumper) ? TeleOpConstants.ASSIST_CLOSED : TeleOpConstants.ASSIST_OPEN);

        // grabber
        if (this.grabberState.equals(GrabberState.CLOSED) && (gamepad2.right_bumper || gamepad1.right_bumper)) {
            // we want to open it partially then
            this.grabberState = GrabberState.PARTIAL;
        }
        else if (this.grabberState.equals(GrabberState.PARTIAL) && !(gamepad2.right_bumper || gamepad1.right_bumper)) {
            // we want to close it by default then then
            this.grabberState = GrabberState.CLOSED;
        }
        else if (gamepad2.dpad_left || gamepad1.dpad_left) {
            // fully open the grabber
            this.grabberState = GrabberState.OPEN;
        }
        else if (this.grabberState.equals(GrabberState.OPEN) && (gamepad2.dpad_right || gamepad1.dpad_right)) {
            // close the grabber from the full position
            this.grabberState = GrabberState.CLOSED;
        }
        */
        /* grabber servo enum controller switch
        switch (this.grabberState) {
            case OPEN:
                this.grabber.setPosition(TeleOpConstants.GRABBER_FULL_OPEN);
                break;
            case PARTIAL:
                this.grabber.setPosition(TeleOpConstants.GRABBER_PARTIAL_OPEN);
                break;
            case CLOSED:
                this.grabber.setPosition(TeleOpConstants.GRABBER_CLOSED);
                break;
        }
        */
            // arm
            //this.arm.setPower(gamepad2.left_stick_y * 0.5);

            // intake
            //this.intake.getMotor1().setPower((this.intake.getMotor1().getPower() == 0) && (gamepad1.x || gamepad2.x) ? 1 : 0);
            //this.intake.getMotor2().setPower((this.intake.getMotor2().getPower() == 0) && (gamepad1.x || gamepad2.x) ? -1 : 0);
            //this.intake.getMotor1().setPower((this.intake.getMotor1().getPower() == 0) && (gamepad1.y || gamepad2.y) ? -1 : 0);
            //this.intake.getMotor2().setPower((this.intake.getMotor2().getPower() == 0) && (gamepad1.y || gamepad2.y) ? 1 : 0);

            // elevator
            //if (gamepad2.right_stick_y >= 0) {
            //    this.elevator.setPower(-gamepad2.right_stick_y* 0.65);
            //}
            //else if (gamepad2.right_stick_y < 0) {
            //    this.elevator.setPower(-gamepad2.right_stick_y);
            //}

        /* clamp
        if (this.clampState.equals(ClampState.UP) && (gamepad2.dpad_down || gamepad1.dpad_down)) {
            // close the clamp
            this.clampState = ClampState.DOWN;
        }
        else if (this.clampState.equals(ClampState.DOWN) && (gamepad2.dpad_up || gamepad1.dpad_up)) {
            // raise the clamp
            this.clampState = ClampState.UP;
        }

        //clamp servo switch controller
        switch (this.clampState) {
            case UP:
                this.clampLeft.setPosition(AutonomousConstants.CLAMP_LEFT_UP);
                this.clampRight.setPosition(AutonomousConstants.CLAMP_RIGHT_UP);
                break;
            case DOWN:
                this.clampLeft.setPosition(AutonomousConstants.CLAMP_LEFT_DOWN);
                this.clampRight.setPosition(AutonomousConstants.CLAMP_RIGHT_DOWN);
                break;
        }

         */


        }

