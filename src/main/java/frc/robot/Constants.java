// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


    /*
    ===============================
               DRIVETRAIN
    ===============================
    */

    public static final int LEFT_FRONT_MOTOR = 10;
    public static final int LEFT_BACK_MOTOR = 11;
    public static final int RIGHT_FRONT_MOTOR = 12;
    public static final int RIGHT_BACK_MOTOR = 13;

    /*
    ===============================
                HOPPER
    ===============================
    */

    public static final int HOPPER_TALON = 26; //Just a random number right now
    public static final double HOPPER_POWER_FORWARD = 0.5;

    /*
    ===============================
                INTAKE
    ===============================
    */

    public static final int INTAKE_FALCON = 2; //Also a random number
    public static final int RIGHT_SOLENOID = 3; //Random
    public static final int LEFT_SOLENOID = 4; //Random

    public static final double INTAKE_SPEED = 1;
    public static final double OUTTAKE_SPEED = 1;

    /*
    ===============================
                SHOOTER
    ===============================
    */

    public static final int TOP_SHOOTER_MOTOR = 5; //Random number
    public static final int BOTTOM_SHOOTER_MOTOR = 6; //Random number

}
