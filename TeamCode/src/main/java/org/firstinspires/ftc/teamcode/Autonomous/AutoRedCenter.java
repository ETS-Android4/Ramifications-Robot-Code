package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Autonomous(name = "AutoRedCenter", group = "Concept")
//@Disabled
public class AutoRedCenter extends LinearOpMode {
    private Robot robot;
    private MecanumDrive mecanumDrive;
    private DcMotor shooter1;
    private DcMotor shooter2;
    double firepower = 0.5;
    private DcMotor arm;
    private Servo claw;
    boolean clawstate = false;
    boolean hopstate = false;
    double firepowerstate = 0.0;
    private DcMotor intake;
    private Servo hopperpush;

    private enum AutoMode {
        MOVE_TO_LINE,
        FIRE_POWER_SHOT,
        PICKUP,
        FIRE_GOAL,
        DROP_WOBBLE,
        PARK_LINE
    };
    private enum FieldMode {
        A, // Wobble zone is on bottom, 0 rings
        B, // Wobble zone is in the middle, 1 ring
        C, // Wobble zone is on top, 4 rings
    }

    private AutoMode autoMode;

    @Override
    public void runOpMode() {
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();
        this.autoMode = AutoMode.MOVE_TO_LINE;

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

        /** Actual code for Auto */
        while (opModeIsActive()) {
            switch (this.autoMode) {
                case MOVE_TO_LINE:
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
                    sleep(100);
                    this.mecanumDrive.stopMoving();
                    this.autoMode = AutoMode.FIRE_POWER_SHOT;
                    break;
                case FIRE_POWER_SHOT:
                    // TODO
                    break;
                case PICKUP:
                    break;
                case FIRE_GOAL:
                    break;
                case DROP_WOBBLE:
                    break;
                case PARK_LINE:
                    break;
            }
        }
    }

}