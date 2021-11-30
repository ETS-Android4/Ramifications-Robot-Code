package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.lang.Math;
import org.firstinspires.ftc.micdsrobotics.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.micdsrobotics.robotplus.hardware.Robot;

// FYI The robot's name is TicondeRobot
// https://gm0.org/en/latest/docs/software/mecanum-drive.html
public class TicondeRobot extends Robot<MecanumDrive> {
    public DcMotor backLeft, backRight, frontLeft, frontRight;
    private final static double SPEED_LIMITER = 0.65;


    @Override
    public void initHardware(HardwareMap hardwareMap) {
        this.backLeft = hardwareMap.get(DcMotor.class, "backleft");
        this.backRight = hardwareMap.get(DcMotor.class, "backright");
        this.frontRight = hardwareMap.get(DcMotor.class, "frontright");
        this.frontLeft = hardwareMap.get(DcMotor.class, "frontleft");
        // reverse the left motors
        this.backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        this.frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public double voltageToDistance(double voltage) {
        return 0;
    }

    public void stopMovement() {
        this.backRight.setPower(0);
        this.frontRight.setPower(0);
        this.frontLeft.setPower(0);
        this.backLeft.setPower(0);
    }

    public void move(double left_y, double left_x, double right_x){
        double y = -left_y;
        double x = left_x;
        double rx = right_x;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = SPEED_LIMITER * ((y + x + rx) / denominator);
        double backLeftPower = SPEED_LIMITER * ((y - x + rx) / denominator);
        double frontRightPower = SPEED_LIMITER * ((y - x - rx) / denominator);
        double backRightPower = SPEED_LIMITER * ((y + x - rx) / denominator);

        this.frontLeft.setPower(frontLeftPower);
        this.frontRight.setPower(frontRightPower);
        this.backLeft.setPower(backLeftPower);
        this.backRight.setPower(backRightPower);

    }
}
