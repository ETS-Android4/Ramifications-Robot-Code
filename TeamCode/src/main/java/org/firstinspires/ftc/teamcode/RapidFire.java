package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.robotplus.hardware.MecanumDrive;

public class RapidFire {
    public static void rapidFire(MecanumDrive mecanumDrive, DcMotor shooter1, DcMotor shooter2, Servo hopperpush, Gamepad gamepad1, Telemetry telemetry) {
        shooter1.setPower(1);
        shooter2.setPower(0.75);
        hopperpush.setPosition(0.0);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(250); } catch (Exception e) { }
        hopperpush.setPosition(1);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(0);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(1);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(0);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(1);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(0);
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(200); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        try { Thread.sleep(250); } catch (Exception e) { }
        mecanumDrive.complexDrive(-gamepad1.right_stick_x, -gamepad1.left_stick_y, -gamepad1.left_stick_x, telemetry);
        hopperpush.setPosition(1);
        shooter1.setPower(0);
        shooter2.setPower(0);
    }
}
