package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Autonomous(name = "AutoRedCenter", group = "Concept")
//@Disabled
public class AutoRedCenter extends LinearOpMode {
    private Robot robot;
    private MecanumDrive mecanumDrive;

    private String most_important;


    @Override
    public void runOpMode() {
        this.most_important = "Pog";
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();

        waitForStart();

        /** Pseudocode for Auto */

        /*
        * Drive to center line
        * Assess what configuration the field is in
        *
        * if (field_config == "A") {
        *   // Square is in lower right
        *   // 0 rings
        *   pick up wobble goal
        *   drive almost to launch line
        *   shoot the three loaded rings into the power-shots
        *   rotate 90 degrees to the right
        *   strafe left 4 in.
        *   drive forward 12 in.
        *   deposit wobble goal
        * }
        * else if (field_config == "B") {
        *   // Square is in middle
        *   // 1 ring
        *   pick up wobble goal
        *   drive almost to launch line
        *   shoot the three pre-loaded rings into the power-shots
        *   drive forward to pick up 1 ring
        *   shoot 1 ring into the top goal
        *   rotate 90 degrees to the right
        *   drive forward a few inches
        *   deposit wobble goal
        * }
        * else if (field_config == "C") {
        *   // Square is in the top right
        *   // Four rings
        *   pick up wobble goal
        *   drive almost to the launch line
        *   shoot the three pre-loaded rings into the power-shots
        *   drive forward and pick up three rings
        *   shoot 3 rings into the top goal
        *   pick up last ring
        *   shoot 1 ring into the top goal
        *   drive forward the last few inches
        *   deposit wobble goal
        * }
        *
        * */
    }

}