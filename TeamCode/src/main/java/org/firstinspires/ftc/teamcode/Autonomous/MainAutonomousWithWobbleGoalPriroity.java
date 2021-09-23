package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.teamcode.MicdsFtcSdk.autonomous.TimeOffsetVoltage;
import org.firstinspires.ftc.teamcode.MicdsFtcSdk.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.MicdsFtcSdk.hardware.Robot;

import java.util.List;


@Autonomous(name = "MainAutonomousWithWobbleGoalPriority", group = "Concept")

public class MainAutonomousWithWobbleGoalPriroity extends LinearOpMode {


    // instance variables for auto

    // Vuforia Nonsense
    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Quad";
    private static final String LABEL_SECOND_ELEMENT = "Single";

    // Field Config
    private Enums.FieldMode fieldMode = Enums.FieldMode.A;

    // Hardware
    private Robot robot;
    private MecanumDrive mecanumDrive;
    private DcMotorEx shooter1;
    private DcMotor shooter2;
    private CRServo hopperpush;
    private DcMotor arm;
    private Servo claw;
    private DcMotor intake;
    private double clawPos = 0.63;

    // For Movement
    private double voltage;



    //license key for our team to use vuforia
    private static final String VUFORIA_KEY = "AXzt31f/////AAABmV9p+iVHU0ZHtGQg7c/xtGhGJJCOO6foIZXqzmKvx7QaM8mjYlhw0ULaoIHkuNgygvO62ZMAIo3p4oQq4gJ7ssX6U7nGNUbX7msGcpya2jt671T4qESqm6Izz+vgTu0box2Yb2Q/JO9Z9jBTdVFQ+EaBY/HF6e7rnjuff3gYVld640+0kE1+s34jc6lLOV/ITgUsD0bZihYjopeTeAGW9YSyxL4WeJza6Hi4vm4Ic+F2/Qcxlxyn65fJoSfGZs70QAqVDL9MVeC4W8sc5djcISaDIoEM7+laAj2DT9Hr71Id486ZB3cQDoBY8QvdbFH7l6GPKs7zeUQlkGDH46M0BCUhLmGQAdjsH4H0UsCA8Obh";

    //more vuforia and robot private instance variables
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;

    @Override
    public void runOpMode() {

        //vuforia and tensor flow initialization methods
        initVuforia();
        initTfod();

        //tensor flow activation and zoom/FOV settings
        if (tfod != null) {
            tfod.activate();

            tfod.setZoom(1.5, 1.5); //uncomment this to adjust field of view or zoom on camera
        }


        //hardware mapping
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();
        this.shooter1 = (DcMotorEx) hardwareMap.get(DcMotor.class, "shooter1");
        this.shooter2 = hardwareMap.get(DcMotor.class, "shooter2");
        this.hopperpush = hardwareMap.get(CRServo.class, "hopperpush");
        this.voltage = hardwareMap.voltageSensor.get("Expansion Hub 10").getVoltage();
        this.arm = hardwareMap.get(DcMotor.class, "arm");
        this.claw = hardwareMap.get(Servo.class, "claw");
        this.intake = hardwareMap.get(DcMotor.class, "intake");

        //telemetry
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();

        //wait for play button
        claw.setPosition(clawPos);
        waitForStart();

        //if the play button has been hit, execute subsequent code
        if (opModeIsActive()) {


            //iterator variable (we could do a for loop, but we probably shouldn't mess with this much at all, since its the way vuforia wants us to do it
            int iterator = 1000;
            while (iterator>0) {
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

                            if (recognition.getLabel().equals("Quad")) { //tell the rest of the auto if we are dealing with quad stack
                                telemetry.addLine("Quad Detected");
                                telemetry.update();
                                this.fieldMode = Enums.FieldMode.C;
                            } else if (recognition.getLabel().equals("Single")) { //tell the rest of the auto if we are dealing with single stack

                                telemetry.addLine("Single Detected");
                                telemetry.update();
                                fieldMode = Enums.FieldMode.B;
                            } else { //tell the rest of the auto if we are dealing with no stack
                                telemetry.addLine("None Detected");
                                telemetry.update();
                                fieldMode = Enums.FieldMode.A;
                            }

                            //Unecessary Telemtry Data Which Was Pushing the USEFUL DATA Away
                            //telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                            //        recognition.getLeft(), recognition.getTop());
                            //telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                            //        recognition.getRight(), recognition.getBottom());
                        }
                        telemetry.update();
                    }
                }
                iterator--;
            }

            sleep(1000);

        }
        //shut down vuforia sequence
        if (tfod != null) {
            tfod.shutdown();
        }

        telemetry.addLine("Proceeding to movement");
        telemetry.addLine("Field Configuration: " + fieldMode.toString());
        telemetry.update();
        sleep(500);



        /*
        Here is where all subsequent Autonomous code can go:
         */

        if (opModeIsActive()) {
            // Moving the robot forward while also positioning the wobble goal

            intake.setPower(-1);
            sleep(100);
            intake.setPower(0);
            sleep(100);
            intake.setPower(1);
            this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(), 1, 0);
            sleep(50);
            this.mecanumDrive.stopMoving();
            claw.setPosition(clawPos);
            sleep(200);
            claw.setPosition(clawPos);
            this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 0.5, 0);
            claw.setPosition(clawPos);
            sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 90));
            this.mecanumDrive.stopMoving();
            claw.setPosition(clawPos);

            //go left
            /*this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(), 0, -1);
            claw.setPosition(clawPos);
            sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 15));
            claw.setPosition(clawPos);
            this.mecanumDrive.stopMoving();*/


            claw.setPosition(clawPos);
            sleep(500);
            claw.setPosition(clawPos);

            // Shooting the pre-loaded rings
            shooter1.setVelocity(1850);
            arm.setPower(-0.65);
            sleep(600);
            arm.setPower(0);
            sleep(100);
            shooter2.setPower(0.75);
            hopperpush.setPower(-0.56);
            sleep(700);
            hopperpush.setPower(0);
            sleep(600);
            hopperpush.setPower(-0.56);
            sleep(700);
            hopperpush.setPower(0);
            sleep(600);
            hopperpush.setPower(-0.56);
            sleep(700);
            hopperpush.setPower(0);
            sleep(100);


            this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(), 0, -1);
            sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 40));
            claw.setPosition(clawPos);
            this.mecanumDrive.stopMoving();
            claw.setPosition(clawPos);

            intake.setPower(0);
            shooter1.setVelocity(0);
            shooter2.setPower(0);
            hopperpush.setPower(0);


            switch (fieldMode) {
                case A: {

                    telemetry.addLine("Field Configuration A running");
                    telemetry.update();

                    // Move Toward Square
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 100));
                    this.mecanumDrive.stopMoving();
                    claw.setPosition(clawPos);

                    // Dropping the Wobble Goal and Driving Away
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 50));
                    claw.setPosition(1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 50));
                    claw.setPosition(clawPos);
                    this.mecanumDrive.stopMoving();

                    break;
                } // I added the brackets so I could collapse it in Android Studio
                case B: {

                    //telemetry
                    telemetry.addLine("Field Configuration B running");
                    telemetry.update();


                    //move toward square
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 130));
                    claw.setPosition(clawPos);
                    this.mecanumDrive.stopMoving();
                    claw.setPosition(clawPos);


                    //strafe to side
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 40));
                    claw.setPosition(clawPos);
                    this.mecanumDrive.stopMoving();
                    claw.setPosition(clawPos);


                    claw.setPosition(1);

                    //strafe to side more
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 75));
                    this.mecanumDrive.stopMoving();


                    //go back for other goal
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(), 1, 0);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 115));
                    this.mecanumDrive.stopMoving();

                    //strafe into goal
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(), 0, -1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 40));
                    this.mecanumDrive.stopMoving();

                    claw.setPosition(0.63);


                    //strafe to wall
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 40));
                    this.mecanumDrive.stopMoving();

                    claw.setPosition(0.63);

                    //move forward
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 140));
                    claw.setPosition(clawPos);
                    this.mecanumDrive.stopMoving();
                    claw.setPosition(clawPos);

                    //strafe to left somewhat
                    claw.setPosition(clawPos);
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(), 0, -1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 65));
                    claw.setPosition(clawPos);
                    this.mecanumDrive.stopMoving();


                    //open claw
                    claw.setPosition(1);


                    //move back to the wall
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 65));
                    this.mecanumDrive.stopMoving();

                    //Move To Line
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(), 1, 0);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 75));
                    this.mecanumDrive.stopMoving();


                    break;
                }
                case C:
                    // Vuforia is detecting a quad where there is none for some reason, so I'm pasting this code here in order to test it.
                    // TODO: Figure out why Vuforia is detecting a quad here
                    telemetry.addLine("Field Configuration A running");
                    telemetry.update();

                    // Move Toward Square
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 60));
                    this.mecanumDrive.stopMoving();
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(), -1, 0);
                    sleep(850);
                    this.mecanumDrive.stopMoving();
                    claw.setPosition(clawPos);
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(), 1, 0);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 30));
                    claw.setPosition(1);
                    this.mecanumDrive.stopMoving();
                    arm.setPower(-0.65);
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(), 0, -1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 100));
                    arm.setPower(0);
                    sleep(100);
                    arm.setPower(0.65);
                    sleep(2500);
                    arm.setPower(0);
                    this.mecanumDrive.stopMoving();
                    claw.setPosition(clawPos);
                    this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 100));
                    claw.setPosition(1);
                    this.mecanumDrive.stopMoving();

                    // Dropping the Wobble Goal and Driving Away
                    /*this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 50));
                    claw.setPosition(1);
                    sleep(TimeOffsetVoltage.calculateDistance(this.voltage, 50));
                    claw.setPosition(clawPos);
                    this.mecanumDrive.stopMoving();*/
                    break;
                default:
                    telemetry.addLine("Field State: " + this.fieldMode.toString());
                    break;
            }
        }

/*
NO MORE AUTO CODE AFTER THIS POINT
 */
    } //end of class

    /**
     * Initialize the Vuforia localization engine.
     */
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

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



}// end of class




