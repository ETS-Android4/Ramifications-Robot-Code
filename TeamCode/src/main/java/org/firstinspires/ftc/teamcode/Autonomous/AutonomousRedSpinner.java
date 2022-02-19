package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.AutonomousTicondeRobot;
import org.firstinspires.ftc.teamcode.TicondeRobot;

@Autonomous(name = "Autonomous Red Spinner", group = "Blue")
public class AutonomousRedSpinner extends LinearOpMode {
    private AutonomousTicondeRobot robot = new AutonomousTicondeRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.initHardware(hardwareMap);

        waitForStart();

        robot.moveToPositionPID(75, telemetry, () -> opModeIsActive());
        robot.setDriveTrainMode(DcMotor.RunMode.RUN_USING_ENCODER);

        robot.move(0, 0, 0.5);
        TicondeRobot.HaltAndCatchFire(550);
        robot.move(0,0,0);
        TicondeRobot.HaltAndCatchFire(50);
        robot.runSpinner(false);
        robot.setMovement(-.25,-0.25,-0.25,-0.25);
        robot.runSpinner(false);
        robot.setMovement(0,0,0,0);


//        robot.setMovement(-.016,-.016,-.016,-.016);
//        robot.runSpinner();
//        robot.setMovement(0,0,0,0);
//        robot.runSpinner();

    }
}
