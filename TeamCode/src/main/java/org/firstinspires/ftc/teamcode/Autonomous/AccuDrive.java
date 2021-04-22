package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;



public class AccuDrive {


    public static void Forward(LinearOpMode lop, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {
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

        //while(minor1.getCurrentPosition() < distance || minor2.getCurrentPosition() < distance || main1.getCurrentPosition() < distance || main2.getCurrentPosition() < distance) {
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
        lop.sleep(500);
        main1.setPower(0);
        main2.setPower(0);
        minor1.setPower(0);
        minor2.setPower(0);
    }





    public static void Backward(LinearOpMode lop, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67*100*0.1389*3*70/69;

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

        //while(minor1.getCurrentPosition() < distance || minor2.getCurrentPosition() < distance || main1.getCurrentPosition() < distance || main2.getCurrentPosition() < distance) {
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
        lop.sleep(500);
        main1.setPower(0);
        main2.setPower(0);
        minor1.setPower(0);
        minor2.setPower(0);

    }


    public static void Right(LinearOpMode lop, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67*100*0.1389*3*70/69;

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

        //while(minor1.getCurrentPosition() < distance || minor2.getCurrentPosition() < distance || main1.getCurrentPosition() < distance || main2.getCurrentPosition() < distance) {
        while(minor1.isBusy() || minor2.isBusy() || main1.isBusy() || main2.isBusy()) {
            lop.telemetry.addLine("minor1 position: " + minor1.getCurrentPosition());
            lop.telemetry.addLine("minor2 position: " + minor2.getCurrentPosition());
            lop.telemetry.addLine("main2 position: " + main2.getCurrentPosition());
            lop.telemetry.addLine("main1 position: " + main1.getCurrentPosition());
            lop.telemetry.update();

            if((minor1.getCurrentPosition() < minor2.getCurrentPosition()) || (main1.getCurrentPosition() < main2.getCurrentPosition())){
                main1.setPower(power);
                main2.setPower(0.85*power);
                minor1.setPower(power);
                minor2.setPower(0.85*power);
            }
            else if((minor1.getCurrentPosition() > minor2.getCurrentPosition()) || (main1.getCurrentPosition() > main2.getCurrentPosition())) {
                main1.setPower(0.85*power);
                main2.setPower(power);
                minor1.setPower(0.85*power);
                minor2.setPower(power);
            }
            else{
                main1.setPower(power);
                main2.setPower(power);
                minor1.setPower(power);
                minor2.setPower(power);
            }

            if(main1.getTargetPosition()== main1.getCurrentPosition()){
                main1.setPower(0);
            }
            if(main2.getTargetPosition()== main2.getCurrentPosition()){
                main2.setPower(0);
            }
            if(minor1.getTargetPosition()== minor1.getCurrentPosition()){
                minor1.setPower(0);
            }
            if(minor2.getTargetPosition()== minor2.getCurrentPosition()){
                minor2.setPower(0);
            }
        }
        lop.sleep(500);
        minor1.setPower(0);
        minor2.setPower(0);
        main1.setPower(0);
        main2.setPower(0);




    }

    public static void Left(LinearOpMode lop, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67*100*0.1389*3*70/69;

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


        //while(minor1.getCurrentPosition() < distance || minor2.getCurrentPosition() < distance || main1.getCurrentPosition() < distance || main2.getCurrentPosition() < distance) {
        while(minor1.isBusy() || minor2.isBusy() || main1.isBusy() || main2.isBusy()) {
            lop.telemetry.addLine("minor1 position: " + minor1.getCurrentPosition());
            lop.telemetry.addLine("minor2 position: " + minor2.getCurrentPosition());
            lop.telemetry.addLine("main2 position: " + main2.getCurrentPosition());
            lop.telemetry.addLine("main1 position: " + main1.getCurrentPosition());
            lop.telemetry.update();

            if((minor1.getCurrentPosition() < minor2.getCurrentPosition()) || (main1.getCurrentPosition() < main2.getCurrentPosition())){
                main1.setPower(power);
                main2.setPower(0.85*power);
                minor1.setPower(power);
                minor2.setPower(0.85*power);
            }
            else if((minor1.getCurrentPosition() > minor2.getCurrentPosition()) || (main1.getCurrentPosition() > main2.getCurrentPosition())) {
                main1.setPower(0.85*power);
                main2.setPower(power);
                minor1.setPower(0.85*power);
                minor2.setPower(power);
            }
            else{
                main1.setPower(power);
                main2.setPower(power);
                minor1.setPower(power);
                minor2.setPower(power);
            }

            if(main1.getTargetPosition()== main1.getCurrentPosition()){
                main1.setPower(0);
            }
            if(main2.getTargetPosition()== main2.getCurrentPosition()){
                main2.setPower(0);
            }
            if(minor1.getTargetPosition()== minor1.getCurrentPosition()){
                minor1.setPower(0);
            }
            if(minor2.getTargetPosition()== minor2.getCurrentPosition()){
                minor2.setPower(0);
            }

        }
        lop.sleep(500);
        minor1.setPower(0);
        minor2.setPower(0);
        main1.setPower(0);
        main2.setPower(0);



    }

    public static void TurnLeft(LinearOpMode lop, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {


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

        //while(minor1.getCurrentPosition() < distance || minor2.getCurrentPosition() < distance || main1.getCurrentPosition() < distance || main2.getCurrentPosition() < distance) {
        while(minor1.isBusy() || minor2.isBusy() || main1.isBusy() || main2.isBusy()) {


        }
        lop.sleep(500);
        minor1.setPower(0);
        minor2.setPower(0);
        main1.setPower(0);
        main2.setPower(0);


    }

    public static void TurnRight(LinearOpMode lop, DcMotor main1, DcMotor main2, DcMotor minor1, DcMotor minor2 , double distance, double power) {

        distance = distance*1.67*100*0.1389*3*70/69;

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

        //while(minor1.getCurrentPosition() < distance || minor2.getCurrentPosition() < distance || main1.getCurrentPosition() < distance || main2.getCurrentPosition() < distance) {
        while(minor1.isBusy() || minor2.isBusy() || main1.isBusy() || main2.isBusy()) {


        }
        lop.sleep(500);
        minor1.setPower(0);
        minor2.setPower(0);
        main1.setPower(0);
        main2.setPower(0);

    }


}
