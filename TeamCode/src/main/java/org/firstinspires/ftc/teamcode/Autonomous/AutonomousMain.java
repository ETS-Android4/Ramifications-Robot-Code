package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.AutonomousTicondeRobot;
import org.firstinspires.ftc.teamcode.AutonomousTicondeRobot;
import org.firstinspires.ftc.teamcode.MotorPower;
import org.firstinspires.ftc.teamcode.TicondeRobot;

@Autonomous(name = "Autonomous Simple V1 1", group = "Basic")
public class AutonomousMain extends LinearOpMode {
    private AutonomousTicondeRobot robot = new AutonomousTicondeRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.initHardware(hardwareMap);

        waitForStart();

        robot.moveToPositionPID(-28 * 5);

        robot.runSpinner();
    }
}
