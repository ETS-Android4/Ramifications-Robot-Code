package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;
import org.firstinspires.ftc.teamcode.robotplus.hardware.Robot;

@Autonomous(name = "shortAuto", group = "Concept")
//@Disabled
public class ShortAuto extends LinearOpMode {
    private Robot robot;
    private MecanumDrive mecanumDrive;
    private DcMotor shooter1;
    private DcMotor shooter2;
    private CRServo hopperpush;
    //private DcMotor arm;
    //private CRServo claw;
    //private DcMotor intake;


    @Override
    public void runOpMode() {
        this.robot = new Robot(hardwareMap);
        this.mecanumDrive = (MecanumDrive) this.robot.getDrivetrain();
        this.shooter1 = hardwareMap.get(DcMotor.class, "shooter1");
        this.shooter2 = hardwareMap.get(DcMotor.class, "shooter2");
        this.hopperpush = hardwareMap.get(CRServo.class, "hopperpush");
        //this.arm = hardwareMap.get(DcMotor.class, "arm");
        //this.claw = hardwareMap.get(CRServo.class, "claw");
        //this.intake = hardwareMap.get(DcMotor.class, "intake");

        waitForStart();

        /*this.arm.setPower(1.0);
        sleep(200);
        this.arm.setPower(0);//adjusts arm to allow for shooting and intake-ing*/

        //this.intake.setPower(1.0); //activates intake

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        sleep(1750);
        this.mecanumDrive.stopMoving(); //moves bot forward to line while intake-ing rings

        //this.intake.setPower(0); //turns off intake

        sleep(250);//provides delay before direction change

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(), 0, -1);
        sleep(1500);
        this.mecanumDrive.stopMoving(); //aligns bot against far wall

        sleep(250);//allows bot to settle against wall

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
        sleep(1000);
        this.mecanumDrive.stopMoving();//moves bot to leftmost power shot

        sleep(250);

        this.shooter1.setPower(1.0);
        this.shooter2.setPower(0.7);
        sleep(500); //speeds up shooters
        this.hopperpush.setPower(-0.5);
        sleep(750);
        this.hopperpush.setPower(0); //launches 1 ring

        sleep(250);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
        sleep(350);
        this.mecanumDrive.stopMoving(); //moves bot to middle power shot

        sleep(250);

        this.hopperpush.setPower(-0.5);
        sleep(750);
        this.hopperpush.setPower(0); //fires another ring

        sleep(250);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
        sleep(350);
        this.mecanumDrive.stopMoving(); //moves bot to rightmost power shot

        sleep(250);

        this.hopperpush.setPower(-0.5);
        sleep(750);
        this.hopperpush.setPower(0); //fires another ring

        sleep(250);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
        sleep(350);
        this.mecanumDrive.stopMoving(); //moves bot to stand

        this.shooter2.setPower(0.75);
        sleep(500); //speeds up shooter for top bin
        this.hopperpush.setPower(-0.5);
        sleep(5000); //fires any other rings picked up
        this.shooter1.setPower(0);
        this.shooter2.setPower(0);
        this.hopperpush.setPower(0); //turns shooters off

        sleep(250);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(), 0, 1);
        sleep(1500);
        this.mecanumDrive.stopMoving(); //resets angle against wall

        sleep(250);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(), 1, 0);
        sleep(1750);
        this.mecanumDrive.stopMoving(); //moves bot to far box

        sleep(250);

        /*this.arm.setPower(1.0);
        sleep(1000); //brings arm to ground
        this.arm.setPower(0);
        this.claw.setPower(1.0);
        sleep(100);
        this.claw.setPower(0);//releases wobble goal*/

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),1,0);
        sleep(3500);
        this.mecanumDrive.stopMoving();//moves bot to back wall

        sleep(250);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,1);
        sleep(500);
        this.mecanumDrive.stopMoving();//aligns bot against near wall

        sleep(250);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.LEFT.angle(),0,-1);
        sleep(1250);
        this.mecanumDrive.stopMoving();//moves bot to second wobble goal

        /*this.claw.setPower(1.0);//opens claw
        sleep(100);
        this.claw.setPower(0);*/

        sleep(250);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        sleep(300);
        this.mecanumDrive.stopMoving();//moves wobble goal into claw

        sleep(250);

        /*this.claw.setPower(1.0);
        sleep(250);
        this.claw.setPower(0);//closes claw*/

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.RIGHT.angle(),0,1);
        sleep(1500);
        this.mecanumDrive.stopMoving();//returns bot to wall and realigns

        sleep(250);

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.UP.angle(),1,0);
        sleep(3500);
        this.mecanumDrive.stopMoving();//returns bot to far square

        sleep(250);

        /*this.claw.setPower(1.0);
        sleep(100);
        this.claw.setPower(0);//releases wobble goal*/

        this.mecanumDrive.complexDrive(MecanumDrive.Direction.DOWN.angle(),1,0);
        sleep(1500);
        this.mecanumDrive.stopMoving();//returns bot to launch line

        /*Test 1 Results:
        1/3 power shots
        Ended on line
        Middle was a mess, need to realign more
        Add delays between different directions*/

    }

}
