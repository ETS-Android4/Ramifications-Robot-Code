package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.robotplus.autonomous.TimeOffsetVoltage;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

public class SimplifiedMovement {
    public void Forward(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),velocity,0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }

    public void Backward(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),velocity,0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }

    public void Right(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,velocity);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }

    public void Left(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,-velocity);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }

    public void TurnRight(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), velocity,0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }

    public void TurnLeft(LinearOpMode lop, Robot robot, MecanumDrive mecanumDrive, double voltage, double distance, double velocity) {
        mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),-velocity,0);
        lop.sleep(TimeOffsetVoltage.calculateDistance(voltage, distance));
        mecanumDrive.stopMoving();
    }
}
