package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.robotplus.autonomous.TimeOffsetVoltage;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

public class SimplifiedMovement {
    private void Forward(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),velocity,0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }

    private void Backward(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),velocity,0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }

    private void Right(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,velocity);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }

    private void Left(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,-velocity);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }

    private void TurnRight(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), velocity,0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }

    private void TurnLeft(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),-velocity,0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }
}
