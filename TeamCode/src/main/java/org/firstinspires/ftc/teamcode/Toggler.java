package org.firstinspires.ftc.teamcode;

public class Toggler {
    public OnToggle onToggle;
    public boolean on, isSamePress;

    public Toggler(boolean initState, OnToggle onToggle) {
        on = initState;
        isSamePress = false;
        this.onToggle = onToggle;
    }

    public void checkAndRun(boolean condition) {
        if (condition) {
            if (!isSamePress) {
                this.on = !this.on;
                isSamePress = true;
            }
        } else {
            isSamePress = false;
        }

        this.onToggle.run(this.on);
    }

    public interface OnToggle{
        public void run(boolean isOn);
    }
}
