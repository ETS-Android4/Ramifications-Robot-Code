package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotplus.autonomous.TimeOffsetVoltage;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

public class SimplifiedMovement {
    private void Forward(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, 150));
        mecanumDrive.stopMoving();
    }

    private void Backward(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),1,0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, 150));
        mecanumDrive.stopMoving();
    }

    private void Right(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,1);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, 150));
        mecanumDrive.stopMoving();
    }

    private void Left(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,-1);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, 150));
        mecanumDrive.stopMoving();
    }
}
