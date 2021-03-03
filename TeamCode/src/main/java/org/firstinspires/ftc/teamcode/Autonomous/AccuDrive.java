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
        distance = distance*1.67*100*0.1389*3*70/69;

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

        while(minor1.isBusy() || minor2.isBusy() || main1.isBusy() || main2.isBusy()) {
            lop.telemetry.addLine("minor1 position: " + minor1.getCurrentPosition());
            lop.telemetry.addLine("minor2 position: " + minor2.getCurrentPosition());
            lop.telemetry.addLine("main2 position: " + main2.getCurrentPosition());
            lop.telemetry.addLine("main1 position: " + main1.getCurrentPosition());
            lop.telemetry.update();

            if((main2.getCurrentPosition() < minor2.getCurrentPosition()) || (main1.getCurrentPosition() < minor1.getCurrentPosition())){
                main1.setPower(power);
                main2.setPower(power);
                minor1.setPower(0.9*power);
                minor2.setPower(0.9*power);
            }
            else if((main2.getCurrentPosition() > minor2.getCurrentPosition()) || (main1.getCurrentPosition() > minor1.getCurrentPosition())) {
                main1.setPower(0.9*power);
                main2.setPower(0.9*power);
                minor1.setPower(power);
                minor2.setPower(power);
            }
            else{
                main1.setPower(power);
                main2.setPower(power);
                minor1.setPower(power);
                minor2.setPower(power);
            }

        }
        main1.setPower(0);
        main2.setPower(0);
        minor1.setPower(0);
        minor2.setPower(0);
    }

    public static void Backward(LinearOpMode lop, Robot robot, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67*100*0.1389*3*70/69*72/69;

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

        while(minor1.isBusy() || minor2.isBusy() || main1.isBusy() || main2.isBusy()) {
            lop.telemetry.addLine("minor1 position: " + minor1.getCurrentPosition());
            lop.telemetry.addLine("minor2 position: " + minor2.getCurrentPosition());
            lop.telemetry.addLine("main2 position: " + main2.getCurrentPosition());
            lop.telemetry.addLine("main1 position: " + main1.getCurrentPosition());
            lop.telemetry.update();

            if((main2.getCurrentPosition() < minor2.getCurrentPosition()) || (main1.getCurrentPosition() < minor1.getCurrentPosition())){
                main1.setPower(power);
                main2.setPower(power);
                minor1.setPower(0.9*power);
                minor2.setPower(0.9*power);
            }
            else if((main2.getCurrentPosition() > minor2.getCurrentPosition()) || (main1.getCurrentPosition() > minor1.getCurrentPosition())) {
                main1.setPower(0.9*power);
                main2.setPower(0.9*power);
                minor1.setPower(power);
                minor2.setPower(power);
            }
            else{
                main1.setPower(power);
                main2.setPower(power);
                minor1.setPower(power);
                minor2.setPower(power);
            }

        }
        main1.setPower(0);
        main2.setPower(0);
        minor1.setPower(0);
        minor2.setPower(0);

    }

    public static void Left(LinearOpMode lop, Robot robot, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67*1000;

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


              /*
        while(minor1.isBusy() || minor2.isBusy() || main1.isBusy() || main2.isBusy()){
            if(main2.getCurrentPosition() < main1.getCurrentPosition()){
                main1.setPower(0.75*power);
                main2.setPower(power);
                minor1.setPower(0.75*power);
                minor2.setPower(power);
            }
            else if(main1.getCurrentPosition() < main2.getCurrentPosition()){
                main1.setPower(power);
                main2.setPower(0.75*power);
                minor1.setPower(power);
                minor2.setPower(0.75*power);
            }
            else{
                main1.setPower(power);
                main2.setPower(power);
                minor1.setPower(power);
                minor2.setPower(power);
            }
        }

         */




    }

    public static void Right(LinearOpMode lop, Robot robot, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67*1000;

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

              /*
        while(minor1.isBusy() || minor2.isBusy() || main1.isBusy() || main2.isBusy()){
            if(minor2.getCurrentPosition() < minor1.getCurrentPosition()){
                main1.setPower(0.75*power);
                main2.setPower(power);
                minor1.setPower(0.75*power);
                minor2.setPower(power);
            }
            else if(minor1.getCurrentPosition() < minor2.getCurrentPosition()){
                main1.setPower(power);
                main2.setPower(0.75*power);
                minor1.setPower(power);
                minor2.setPower(0.75*power);
            }
            else{
                main1.setPower(power);
                main2.setPower(power);
                minor1.setPower(power);
                minor2.setPower(power);
            }
        }

         */
    }

    public static void TurnRight(LinearOpMode lop, Robot robot, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67*1000;

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

        distance = distance*1.67*1000;

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
