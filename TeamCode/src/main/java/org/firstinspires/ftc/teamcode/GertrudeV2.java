package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.lang.Math;
import org.firstinspires.ftc.micdsrobotics.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.micdsrobotics.robotplus.hardware.Robot;

// FYI The robot's name is GertrudeV2
public class GertrudeV2 extends Robot<MecanumDrive> {
    public DcMotor backLeft, backRight, frontLeft, frontRight;

    @Override
    public void initHardware(HardwareMap hardwareMap) {
        this.backLeft = hardwareMap.get(DcMotor.class, "backleft");
        this.backRight = hardwareMap.get(DcMotor.class, "backright");
        this.frontRight = hardwareMap.get(DcMotor.class, "frontright");
        this.frontLeft = hardwareMap.get(DcMotor.class, "frontleft");
    }

    @Override
    public double voltageToDistance(double voltage) {
        return 0;
    }

    public void setForwardPower(double speed) {
        speed = Math.min(Math.max(0, speed), 1);
        this.backRight.setPower(speed);
        this.frontRight.setPower(speed);
        this.frontLeft.setPower(-speed);
        this.backLeft.setPower(-speed);
    }
}
