// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.SPI;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
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

    public static final int GYRO_PORT = 0; //random 

    public static final int ENCODER_TICKS_PER_INCH = 15; 

    public static final SPI.Port m_gyroPort = SPI.Port.kOnboardCS0; 

    /*
    ===============================
                HOPPER
    ===============================
    */

    public static final int HOPPER_TALON = 26; //Just a random number right now
    public static final double HOPPER_POWER_FORWARD = 1;
    public static final double HOPPER_POWER_REVERSE = 1; //random

    /*
    ===============================
                INTAKE
    ===============================
    */

    public static final int INTAKE_FALCON = 19; //Also a random number
    public static final int RIGHT_SOLENOID = 0; //Random
    public static final int LEFT_SOLENOID = 1; //Random

    public static final double INTAKE_SPEED = 0.75;
    public static final double OUTTAKE_SPEED = 1; //Random

     /*
    ===============================
                CLIMBER
    ===============================
    */

    public static final int CLIMBER_MOTOR = 0; 

    public static final double CLIMB_SPEED = 1;
    public static final double REVERSE_CLIMB_SPEED = 1; 

    /*
    ===============================
                SHOOTER
    ===============================
    */

    public static final int TOP_SHOOTER_MOTOR = 5; 
    public static final int BOTTOM_SHOOTER_MOTOR = 6; 
    public static final double SHOOTER_POWER = 1;

    // ****ENCODER****

    public static final int TIMEOUT_MS = 30; //30 ms timeout time

    // ****PID****

    public static final int PID_LOOP_IDX = 0;

    // ****GAINS****

    public static final double GAINS_VELOCITY_F = 750; //need to tune
    public static final double GAINS_VELOCITY_P = 0.1; //need to tune
    public static final double GAINS_VELOCITY_I = 0.001; //need to tune
    public static final double GAINS_VELOCITY_D = 5; //need to tune

    /*
    ===============================
            AUTO CONSTANTS
    ===============================
    */

    // ****BASIC AUTON & BASIC AUTON REVERSE****

    public static final double BASIC_AUTON_DRIVE_SPEED = -0.2; //Drive speed in basic auton
    public static final double BASIC_AUTON_REVERSE_SPEED = 0.2; //Drive speed in basic auton reverse
    public static final double BASIC_AUTON_DISTANCE = 50000; //Encoder ticks to drive in basic autons

    // **** THREE BALL AUTON- TIMER ****

    public static final double THREE_BALL_TIMEOUT = 5.0;
    public static final double THREE_BALL_INITIAL_DRIVE = 1.23;
    public static final double THREE_BALL_SPIN_UP = 3.0;
    public static final double THREE_BALL_HOPPER_RUN = 3.0;
    public static final double THREE_BALL_DRIVE_BACK = 3.0;

    public static final double THREE_BALL_DRIVE_SPEED = -0.4;
    public static final double THREE_BALL_SHOOT_SPEED = 1;
    public static final double THREE_BALL_HOPPER_SPEED = 0.8;

    // **** THREE BALL AUTON- ENCODERS ****

    public static final double THREE_BALL_DRIVE_DISTANCE = 85500;


}