package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.AutonomousTicondeRobot;

@Autonomous(name = "Autonomous V1 RED Depot", group = "Basic")
public class AutonomousMain2 extends LinearOpMode {
    private AutonomousTicondeRobot robot = new AutonomousTicondeRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.initHardware(hardwareMap);
        robot.intakeRotate.setPosition(1);

        waitForStart();

        robot.moveToPositionPID(420, telemetry, () -> opModeIsActive());
    }
}
