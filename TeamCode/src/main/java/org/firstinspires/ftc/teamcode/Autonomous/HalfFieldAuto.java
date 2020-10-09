package org.firstinspires.ftc.teamcode.Autonomous;
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
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;

@Autonomous(name = "HalfFieldAuto", group = "Concept")
//@Disabled
public class HalfFieldAuto extends LinearOpMode {
    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Quad";
    private static final String LABEL_SECOND_ELEMENT = "Single";
    private static final String VUFORIA_KEY =
            "AXzt31f/////AAABmV9p+iVHU0ZHtGQg7c/xtGhGJJCOO6foIZXqzmKvx7QaM8mjYlhw0ULaoIHkuNgygvO62ZMAIo3p4oQq4gJ7ssX6U7nGNUbX7msGcpya2jt671T4qESqm6Izz+vgTu0box2Yb2Q/JO9Z9jBTdVFQ+EaBY/HF6e7rnjuff3gYVld640+0kE1+s34jc6lLOV/ITgUsD0bZihYjopeTeAGW9YSyxL4WeJza6Hi4vm4Ic+F2/Qcxlxyn65fJoSfGZs70QAqVDL9MVeC4W8sc5djcISaDIoEM7+laAj2DT9Hr71Id486ZB3cQDoBY8QvdbFH7l6GPKs7zeUQlkGDH46M0BCUhLmGQAdjsH4H0UsCA8Obh";
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
    private MecanumDrive mecanumDrive;

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

        /** Wait for the game to begin */
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();
        waitForStart();

        if (opModeIsActive()) {
                //detect objects
                if (tfod != null) {
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Object Detected", updatedRecognitions.size());
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

                    //proceed with deciding where to place wobble goal
                    sleep(500);
                    telemetry.addData("ring count detected", updatedRecognitions.size());
                    telemetry.addData("INSTRUCTION SET", "positioning the wobble goal");
                    telemetry.update();
                    sleep(1000);

                    int step = 0;

                    if(updatedRecognitions.size() == 0){
                        step = 0;
                    }
                    if(updatedRecognitions.size() == 1){
                        step = 1;
                    }
                    if(updatedRecognitions.size() <= 2){
                        step = 2;
                    }


                    //start actions
                    switch (step) {
                        //actions to place the wobble goal for each of the three cases
                        case 0:
                            // TODO: 10/9/2020  ACTIONS TO PLACE WOBBLE GOAL WITH A STACK OF 0
                            sleep(500);
                            telemetry.addData("INSTRUCTION SET", "moving wobble goal");
                            telemetry.update();
                            sleep(500);


                            /* MECANUM EXAMPLE CODE:
                            this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
                            sleep(10);
                            this.mecanumDrive.stopMoving();
                             */
                            step=3;
                            break;


                        case 1:
                            // TODO: 10/9/2020  ACTIONS TO PLACE WOBBLE GOAL WITH A STACK OF 1
                            sleep(500);
                            telemetry.addData("INSTRUCTION SET", "moving wobble goal");
                            telemetry.update();
                            sleep(500);


                            /* MECANUM EXAMPLE CODE:
                            this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),1,0);
                            sleep(500);
                            this.mecanumDrive.stopMoving();
                            */
                            step=3;
                            break;

                        case 2:
                            // TODO: 10/9/2020  ACTIONS TO PLACE WOBBLE GOAL WITH A STACK OF 2
                            sleep(500);
                            telemetry.addData("INSTRUCTION SET", "moving wobble goal");
                            telemetry.update();
                            sleep(500);

                            /* MECANUM EXAMPLE CODE:
                            this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),1,0);
                            sleep(500);
                            this.mecanumDrive.stopMoving();
                            */
                            step=3;
                            break;

                            //proceed with rest of autonomous


                        case 3:
                            sleep(500);
                            telemetry.addData("INSTRUCTION SET", "wobble goal positioned. Proceeding with the rest of auto");
                            telemetry.update();
                            sleep(1000);
                            // TODO: 10/9/2020  Actions after placing the wobble goal

                            // TODO: 10/9/2020 remove this sleep later
                            sleep(20000);

                            /* MECANUM EXAMPLE CODE:
                            this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),1,0);
                            sleep(500);
                            this.mecanumDrive.stopMoving();
                            */
                            step++;
                            break;




                    }


            }
        }

        if (tfod != null) {
            tfod.shutdown();
        }
    }
    private void initVuforia() {
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CameraDirection.BACK;
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
       }
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.8f;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }
}
