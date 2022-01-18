package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.AutonomousTicondeRobot;

@Autonomous(name = "Autonomous Red Depot V1", group = "Red")
public class AutonomousRedDepot extends LinearOpMode {
    private AutonomousTicondeRobot robot = new AutonomousTicondeRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.initHardware(hardwareMap);
        robot.intakeRotate.setPosition(1);

        waitForStart();

        robot.moveToPositionPID(420, telemetry, () -> opModeIsActive());
    }
}
