 package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.robotplus.autonomous.TimeOffsetVoltage;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

public class AccuDrive {
    public static void Forward(LinearOpMode lop, Robot robot, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {
        distance = distance*1.67;

        main1.setDirection(DcMotorSimple.Direction.FORWARD);
        main1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main1.setTargetPosition((int) distance);
        main1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main1.setPower(power);

        main2.setDirection(DcMotorSimple.Direction.FORWARD);
        main2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main2.setTargetPosition((int) distance);
        main2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main2.setPower(power);

        minor1.setDirection(DcMotorSimple.Direction.REVERSE);
        minor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor1.setTargetPosition((int) distance);
        minor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor1.setPower(power);

        minor2.setDirection(DcMotorSimple.Direction.REVERSE);
        minor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor2.setTargetPosition((int) distance);
        minor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor2.setPower(power);


    }

    public static void Backward(LinearOpMode lop, Robot robot, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67;

        main1.setDirection(DcMotorSimple.Direction.REVERSE);
        main1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main1.setTargetPosition((int) distance);
        main1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main1.setPower(power);

        main2.setDirection(DcMotorSimple.Direction.REVERSE);
        main2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main2.setTargetPosition((int) distance);
        main2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main2.setPower(power);

        minor1.setDirection(DcMotorSimple.Direction.FORWARD);
        minor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor1.setTargetPosition((int) distance);
        minor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor1.setPower(power);

        minor2.setDirection(DcMotorSimple.Direction.FORWARD);
        minor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor2.setTargetPosition((int) distance);
        minor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor2.setPower(power);
    }

    public static void Left(LinearOpMode lop, Robot robot, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67;

        main1.setDirection(DcMotorSimple.Direction.FORWARD);
        main1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main1.setTargetPosition((int) distance);
        main1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main1.setPower(power);

        main2.setDirection(DcMotorSimple.Direction.REVERSE);
        main2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main2.setTargetPosition((int) distance);
        main2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main2.setPower(power);

        minor1.setDirection(DcMotorSimple.Direction.REVERSE);
        minor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor1.setTargetPosition((int) distance);
        minor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor1.setPower(power);

        minor2.setDirection(DcMotorSimple.Direction.FORWARD);
        minor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor2.setTargetPosition((int) distance);
        minor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor2.setPower(power);
    }

    public static void Right(LinearOpMode lop, Robot robot, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67;

        main1.setDirection(DcMotorSimple.Direction.REVERSE);
        main1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main1.setTargetPosition((int) distance);
        main1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main1.setPower(power);

        main2.setDirection(DcMotorSimple.Direction.FORWARD);
        main2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main2.setTargetPosition((int) distance);
        main2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main2.setPower(power);

        minor1.setDirection(DcMotorSimple.Direction.FORWARD);
        minor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor1.setTargetPosition((int) distance);
        minor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor1.setPower(power);

        minor2.setDirection(DcMotorSimple.Direction.REVERSE);
        minor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor2.setTargetPosition((int) distance);
        minor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor2.setPower(power);
    }

    public static void TurnRight(LinearOpMode lop, Robot robot, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67;

        main1.setDirection(DcMotorSimple.Direction.FORWARD);
        main1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main1.setTargetPosition((int) distance);
        main1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main1.setPower(power);

        main2.setDirection(DcMotorSimple.Direction.FORWARD);
        main2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main2.setTargetPosition((int) distance);
        main2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main2.setPower(power);

        minor1.setDirection(DcMotorSimple.Direction.FORWARD);
        minor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor1.setTargetPosition((int) distance);
        minor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor1.setPower(power);

        minor2.setDirection(DcMotorSimple.Direction.FORWARD);
        minor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor2.setTargetPosition((int) distance);
        minor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor2.setPower(power);
    }

    public static void TurnLeft(LinearOpMode lop, Robot robot, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67;

        main1.setDirection(DcMotorSimple.Direction.REVERSE);
        main1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main1.setTargetPosition((int) distance);
        main1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main1.setPower(power);

        main2.setDirection(DcMotorSimple.Direction.REVERSE);
        main2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        main2.setTargetPosition((int) distance);
        main2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        main2.setPower(power);

        minor1.setDirection(DcMotorSimple.Direction.REVERSE);
        minor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor1.setTargetPosition((int) distance);
        minor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor1.setPower(power);

        minor2.setDirection(DcMotorSimple.Direction.REVERSE);
        minor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        minor2.setTargetPosition((int) distance);
        minor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        minor2.setPower(power);
    }
}
