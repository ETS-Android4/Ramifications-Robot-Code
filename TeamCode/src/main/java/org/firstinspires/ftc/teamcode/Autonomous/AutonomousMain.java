package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonomousTicondeRobot;

@Autonomous(name = "Autonomous Simple V1", group = "Basic")
public class AutonomousMain extends LinearOpMode {
    private AutonomousTicondeRobot robot = new AutonomousTicondeRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.initHardware(hardwareMap);

        waitForStart();

        robot.moveToPositionPID(-28 * 5, telemetry);

        robot.runSpinner();
    }
}
