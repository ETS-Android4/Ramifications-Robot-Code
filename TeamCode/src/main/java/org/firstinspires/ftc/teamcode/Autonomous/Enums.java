package org.firstinspires.ftc.teamcode.Autonomous;

public class Enums {
    public enum AutoMode {
        PICK_UP_WOBBLE,
        MOVE_TO_LINE,
        FIRE_POWER_SHOT,
        PICKUP,
        FIRE_GOAL,
        DROP_WOBBLE,
        PARK_LINE
    };
    public enum FieldMode {
        UNKNOWN, // We don't know where anything is (default)
        A, // Wobble zone is on bottom, 0 rings
        B, // Wobble zone is in the middle, 1 ring
        C, // Wobble zone is on top, 4 rings
    }
}
