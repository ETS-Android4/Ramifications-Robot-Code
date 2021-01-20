package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;

import static java.lang.Thread.sleep;

public class RapidFire {
    public static void rapidFire(DcMotor shooter1, DcMotor shooter2, Servo hopperpush, int numRings) { // For auto
        shooter1.setPower(1);
        shooter2.setPower(0.75);
        for (int i = 0; i < numRings; ++i) {
            hopperpush.setPosition(0);
            try { sleep(250); } catch (Exception e) { }
            hopperpush.setPosition(1);
        }
        shooter1.setPower(0);
        shooter2.setPower(0);
    }
    public static void rapidFire(DcMotor shooter1, DcMotor shooter2, Servo hopperpush, Telemetry telemetry, MecanumDrive mecanumDrive, Gamepad gamepad1) {
        shooter1.setPower(1);
        shooter2.setPower(0.75);
        hopperpush.setPosition(0.0);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(250); } catch (Exception e) { }
        hopperpush.setPosition(1);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(0);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(1);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(0);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(1);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(0);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(1);
        shooter1.setPower(0);
        shooter2.setPower(0);
    }
}
