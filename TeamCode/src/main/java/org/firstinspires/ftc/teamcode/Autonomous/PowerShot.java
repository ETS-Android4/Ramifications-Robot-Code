package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotplus.autonomous.TimeOffsetVoltage;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

public class PowerShot {
    private void powerShot(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, DcMotor shooter1, DcMotor shooter2, CRServo hopperpush,  double voltage){
        shooter1.setPower(1.0);
        shooter2.setPower(0.7);
        lop.sleep(500);
        hopperpush.setPower(1.0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, 10));
        hopperpush.setPower(0);

        lop.sleep(100);

        mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(),0,-1);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, 10));
        mecanumDrive.stopMoving();

        lop.sleep(100);

        hopperpush.setPower(1.0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage,33));
        hopperpush.setPower(0);

        lop.sleep(100);

        mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(),0,-1);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, 10));
        mecanumDrive.stopMoving();

        lop.sleep(100);

        hopperpush.setPower(1.0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage,33));
        hopperpush.setPower(0);

        lop.sleep(100);

    }
}
