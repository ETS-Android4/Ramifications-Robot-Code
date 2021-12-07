package org.firstinspires.ftc.teamcode;


// A simple class to wrap all four movement motor powers
public class MotorPower {
    public double frontRightPower, frontLeftPower, backRightPower, backLeftPower;

    public MotorPower(double fr, double fl, double br, double bl) {
        this.frontRightPower = fr;
        this.frontLeftPower = fl;
        this.backRightPower = br;
        this.backLeftPower = bl;
    }

    @Override
    public String toString(){
        return String.format("|%-5.3f %5.3f|\n|%-5.3f %5.3f|", frontLeftPower, frontRightPower, backLeftPower, backRightPower);
    }
}
