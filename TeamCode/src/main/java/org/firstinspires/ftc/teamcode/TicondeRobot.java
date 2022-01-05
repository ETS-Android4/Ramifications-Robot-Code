package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import java.lang.Math;
import static java.lang.Thread.sleep;
import org.firstinspires.ftc.micdsrobotics.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.micdsrobotics.robotplus.hardware.Robot;

// FYI The robot's name is TicondeRobot
// https://gm0.org/en/latest/docs/software/mecanum-drive.html
public class TicondeRobot extends Robot<MecanumDrive> {
    public DcMotor backLeft, backRight, frontLeft, frontRight, outtakeRaise, outtakeLower, spinner;
    public Servo intakeRotate, outtakeRotate, intakeSpinnerLeft, intakeSpinnerRight;

    private final static double SPEED_LIMITER = 0.65;
    public final static int ULTRA_PLANETARY_TICKS_PER_REV = 28;
    public final static MotorPower STOP_ALL = new MotorPower(0, 0, 0, 0);


    @Override
    public void initHardware(HardwareMap hardwareMap) {
        this.backLeft = hardwareMap.get(DcMotor.class, "backleft");
        this.backRight = hardwareMap.get(DcMotor.class, "backright");
        this.frontRight = hardwareMap.get(DcMotor.class, "frontright");
        this.frontLeft = hardwareMap.get(DcMotor.class, "frontleft");

        // reverse the left motors
        this.backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        this.frontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        //tell the drivetrain to brake on zero power
        this.backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //intake + outtake
        this.intakeRotate = hardwareMap.get(Servo.class, "intake");
        this.outtakeRotate = hardwareMap.get(Servo.class, "outtake");
        this.outtakeRaise = hardwareMap.get(DcMotor.class, "outtakeRaise");
        this.spinner = hardwareMap.get(DcMotor.class, "spinnyWheel");
        this.outtakeLower = hardwareMap.get(DcMotor.class, "outtakeLower");
        this.intakeSpinnerLeft = hardwareMap.get(Servo.class, "left_spin_intake");
        this.intakeSpinnerRight = hardwareMap.get(Servo.class, "right_spin_intake");

        //reverse servos or motors that need to be reversed
        this.spinner.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public double voltageToDistance(double voltage) {
        return 0;
    }

    public void setMovement(MotorPower power){
        this.backRight.setPower(power.backRightPower);
        this.frontRight.setPower(power.frontRightPower);
        this.frontLeft.setPower(power.frontLeftPower);
        this.backLeft.setPower(power.backLeftPower);
    }

    public void setMovement(double fr, double fl, double br, double bl) {
        this.backRight.setPower(br);
        this.frontRight.setPower(fr);
        this.frontLeft.setPower(fl);
        this.backLeft.setPower(bl);
    }

    public MotorPower move(double left_y, double left_x, double right_x){
        double y = -left_y;
        double x = left_x;
        double rx = right_x;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = SPEED_LIMITER * ((y + x + rx) / denominator);
        double backLeftPower = SPEED_LIMITER * ((y - x + rx) / denominator);
        double frontRightPower = SPEED_LIMITER * ((y - x - rx) / denominator);
        double backRightPower = SPEED_LIMITER * ((y + x - rx) / denominator);

        MotorPower power = new MotorPower(frontRightPower, frontLeftPower, backRightPower, backLeftPower);
        this.setMovement(power);

        return power;
    }

    // sleep function
    public static void HaltAndCatchFire(long milli) {
        try {
            sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setDriveTrainMode(DcMotor.RunMode mode){
        backRight.setMode(mode);
        backLeft.setMode(mode);
        frontRight.setMode(mode);
        frontLeft.setMode(mode);
    }


}
