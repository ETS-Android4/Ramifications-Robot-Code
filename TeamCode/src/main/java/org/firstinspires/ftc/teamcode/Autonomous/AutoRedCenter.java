package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RapidFire;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;


@Autonomous(name = "AutoRedCenter", group = "Concept")
//@Disabled
public class AutoRedCenter extends LinearOpMode {
    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Quad";
    private static final String LABEL_SECOND_ELEMENT = "Single";
    private static final String VUFORIA_KEY =
            "AXzt31f/////AAABmV9p+iVHU0ZHtGQg7c/xtGhGJJCOO6foIZXqzmKvx7QaM8mjYlhw0ULaoIHkuNgygvO62ZMAIo3p4oQq4gJ7ssX6U7nGNUbX7msGcpya2jt671T4qESqm6Izz+vgTu0box2Yb2Q/JO9Z9jBTdVFQ+EaBY/HF6e7rnjuff3gYVld640+0kE1+s34jc6lLOV/ITgUsD0bZihYjopeTeAGW9YSyxL4WeJza6Hi4vm4Ic+F2/Qcxlxyn65fJoSfGZs70QAqVDL9MVeC4W8sc5djcISaDIoEM7+laAj2DT9Hr71Id486ZB3cQDoBY8QvdbFH7l6GPKs7zeUQlkGDH46M0BCUhLmGQAdjsH4H0UsCA8Obh";

    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
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
    private int storedRings = 0;
    private int fieldRings;
    private ColorSensor groundSensor;
    private boolean wobbleIn = false;

    private Enums.AutoMode autoMode;
    private Enums.FieldMode fieldMode;
    private Enums.AutoMode pickupConfig;

    @Override
    public void runOpMode() {

        initVuforia();
        initTfod();

        if (tfod != null) {
            tfod.activate();

            // The TensorFlow software will scale the input images from the camera to a lower resolution.
            // This can result in lower detection accuracy at longer distances (> 55cm or 22").
            // If your target is at distance greater than 50 cm (20") you can adjust the magnification value
            // to artificially zoom in to the center of image.  For best results, the "aspectRatio" argument
            // should be set to the value of the images used to create the TensorFlow Object Detection model
            // (typically 1.78 or 16/9).

            // Uncomment the following line if you want to adjust the magnification and/or the aspect ratio of the input images.
            //tfod.setZoom(2.5, 1.78);
        }

        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();
        this.autoMode = Enums.AutoMode.MOVE_TO_LINE;
        this.fieldMode = Enums.FieldMode.A;
        this.shooter1 = hardwareMap.get(DcMotor.class, "shooter1");
        this.shooter2 = hardwareMap.get(DcMotor.class, "shooter2");
        this.arm = hardwareMap.get(DcMotor.class, "arm");
        this.claw = hardwareMap.get(Servo.class, "claw");
        claw.setPosition(0);
        this.hopperpush = hardwareMap.get(Servo.class, "hopperpush");
        this.intake = hardwareMap.get(DcMotor.class, "intake");
        hopperpush.setPosition(0.5);
        this.groundSensor = hardwareMap.get(ColorSensor.class, "groundSensor");




        switch(this.fieldMode) {
            case A:
                this.fieldRings = 0;
                break;
            case B:
                this.fieldRings = 1;
                break;
            case C:
                this.fieldRings = 4;
                break;
        }

        waitForStart();

        /** Pseudocode for Auto */
        /*

        //Drive to center line
        //Assess what configuration the field is in

        if (field_config == "A") { <-- LUCAS IS DOING THIS BOI
            // Square is in lower right
            // 0 rings
            //pick up wobble goal
            //drive almost to launch line
            //shoot the three loaded rings into the power-shots
            //rotate 90 degrees to the right
            //strafe left 4 in.
            //drive forward 12 in.
            //deposit wobble goal
        }
        else if (field_config == "B") { //<-- BAZ IS DOING
            // Square is in middle
            // 1 ring
            //pick up wobble goal

            //WOBBLE GOAL PICKUP SEQUENCE:
            arm.setPower(-1);
            sleep(150);
            arm.setPower(0);
            this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
            sleep(50);
            this.mecanumDrive.stopMoving();

            //drive almost to launch line
            this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
            sleep(500);
            this.mecanumDrive.stopMoving();

            //shoot the three pre-loaded rings into the power-shots

            RapidFire.rapidFire(shooter1, shooter2, hopperpush, this.fieldRings);

            //drive forward to pick up 1 ring

            this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
            sleep(500);
            this.mecanumDrive.stopMoving();


            //shoot 1 ring into the top goal

            this.shooter1.setPower(1);
            this.shooter2.setPower(1);
            sleep(500);
            this.shooter1.setPower(0);
            this.shooter1.setPower(0);

            //rotate 90 degrees to the right

            this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,1);
            sleep(1000);
            this.mecanumDrive.stopMoving();

            //drive forward a few inches

            this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
            sleep(500);
            this.mecanumDrive.stopMoving();

            //deposit wobble goal
        }
        else if (field_config == "C") {
            // Square is in the top right
            // Four rings
            //pick up wobble goal
            //drive almost to the launch line
            //shoot the three pre-loaded rings into the power-shots
            //drive forward and pick up three rings
            //shoot 3 rings into the top goal
            //pick up last ring
            //shoot 1 ring into the top goal
            //drive forward the last few inches
            //deposit wobble goal
        }*/

        while (!opModeIsActive()) {
            if (tfod != null) {
                // getUpdatedRecognitions() will return null if no new information is available since
                // the last time that call was made.
                List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                if (updatedRecognitions != null) {
                    telemetry.addData("# Object Detected", updatedRecognitions.size());

                    // step through the list of recognitions and display boundary info.
                    int i = 0;
                    for (Recognition recognition : updatedRecognitions) {
                        telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
                        telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                                recognition.getLeft(), recognition.getTop());
                        telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                                recognition.getRight(), recognition.getBottom());
                    }
                    telemetry.update();
                }
            }
        }

        while (!opModeIsActive()) {
            if (tfod != null) {
                // getUpdatedRecognitions() will return null if no new information is available since
                // the last time that call was made.
                List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                if (updatedRecognitions != null) {
                    telemetry.addData("# Object Detected", updatedRecognitions.size());

                    // step through the list of recognitions and display boundary info.
                    int i = 0;
                    for (Recognition recognition : updatedRecognitions) {
                        telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
                        telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                                recognition.getLeft(), recognition.getTop());
                        telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                                recognition.getRight(), recognition.getBottom());
                    }
                    telemetry.update();
                }
            }


            if (!opModeIsActive()) {
                if (tfod != null) {
                    tfod.shutdown();
                }
            }
        }


        /** Actual code for Auto */
        while (opModeIsActive()) {
            switch (this.autoMode) {
                case PICK_UP_WOBBLE:
                    if (wobbleIn) {
                        arm.setPower(-1);
                        sleep(150);
                        arm.setPower(0);
                        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
                        sleep(50);
                        this.mecanumDrive.stopMoving();
                    }
                    this.autoMode = Enums.AutoMode.MOVE_TO_LINE;
                    break;
                case MOVE_TO_LINE:
                    while (this.groundSensor.blue() < 200) {
                        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
                        telemetry.addLine("Blue: " + this.groundSensor.blue());
                        telemetry.update();
                        sleep(50);
                    }
                    this.mecanumDrive.stopMoving();
                    this.autoMode = Enums.AutoMode.FIRE_POWER_SHOT;
                    break;
                case FIRE_POWER_SHOT:
                    // TODO: Make powershot algorithm
                    RapidFire.rapidFire(shooter1,shooter2,hopperpush,storedRings);
                    this.autoMode = pickupConfig;
                    break;
                case PICKUP:
                    this.intake.setPower(0.5);
                    int currentRings = this.fieldRings;
                    for (int i = currentRings; i > 0; --i) {
                        sleep(1500);
                        if (this.storedRings == 3) {
                            break;
                        }
                        this.fieldRings -= 1;
                    }
                    this.intake.setPower(0);
                    this.autoMode = Enums.AutoMode.FIRE_GOAL;
                    break;
                case FIRE_GOAL:
                    RapidFire.rapidFire(shooter1,shooter2,hopperpush,storedRings);
                    if (this.fieldRings > 0) {
                        this.autoMode = Enums.AutoMode.PICKUP;
                    } else {
                        this.autoMode = Enums.AutoMode.DROP_WOBBLE;
                    }
                    break;
                case DROP_WOBBLE:
                    // TODO: Drop wobble
                    this.arm.setPower(1);
                    sleep(150);
                    this.arm.setPower(0);
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),1,0);
                    sleep(50);
                    this.mecanumDrive.stopMoving();
                    this.autoMode = Enums.AutoMode.PARK_LINE;
                    break;
                case PARK_LINE:
                    while (this.groundSensor.blue() < 200) {
                        this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(), 1, 0);
                        telemetry.addLine(String.valueOf(this.groundSensor.blue()));
                        telemetry.update();
                        sleep(50);
                    }
                    sleep(50);
                    this.mecanumDrive.stopMoving();
                    break;
            }

        }
    }
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CameraDirection.BACK;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    /**
     * Initialize the TensorFlow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.8f;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }




}



/*



        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        sleep(500);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,1);
        sleep(600);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),1,0);
        sleep(500);
        this.mecanumDrive.stopMoving();

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(),0,-1);
        sleep(600);
        this.mecanumDrive.stopMoving();

*/


