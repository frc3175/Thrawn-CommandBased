// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.wpilibj.XboxController.Button;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.Drive;
import frc.robot.commands.HopperSpin;
import frc.robot.commands.IntakeDown;
import frc.robot.commands.ShootPowerCell;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter; 
import frc.robot.subsystems.Intake;
import frc.robot.commands.IntakePowerCell;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.ClimbUp;
import frc.robot.commands.ClimbWithEncoder;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Climber;
import frc.robot.automodes.BasicAuton;
import frc.robot.automodes.BasicAutonReverse;
import frc.robot.automodes.TestAuton;
import frc.robot.automodes.ThreeBallAuton;
import frc.robot.automodes.ThreeBallAutonEncoders;
import frc.robot.commands.AgitateHopper;
import frc.robot.commands.AgitateIntake;
import frc.robot.commands.ClimbDown;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain= new Drivetrain();
  private final Hopper m_hopper = new Hopper();
  private final Shooter m_shooter = new Shooter();
  private final Intake m_intake = new Intake();
  private final Climber m_climber = new Climber();
  XboxController m_driverController = new XboxController(0);
  XboxController m_operatorController = new XboxController(1);
  //private boolean m_quickTurn = m_driverController.getBumperPressed(Hand.kLeft);

//These are each of the autonomous commands that we can run
  Command m_basicAuton = new BasicAuton(m_drivetrain);
  Command m_basicAutonReverse = new BasicAutonReverse(m_drivetrain);
  Command m_threeBallAuton = new ThreeBallAuton(m_drivetrain, m_shooter, m_hopper, m_intake);
  Command m_threeBallAutonEncoders = new ThreeBallAutonEncoders(m_drivetrain, m_shooter, m_hopper);
  Command m_testAuton = new TestAuton(m_drivetrain, m_shooter, m_hopper, m_intake);

//Set the default command in the constructor
  public RobotContainer() {
      m_drivetrain.setDefaultCommand( 
      new Drive( 
          m_drivetrain,
          () -> m_driverController.getTriggerAxis(GenericHID.Hand.kLeft),
          () -> m_driverController.getTriggerAxis(GenericHID.Hand.kRight),
          () ->  m_driverController.getX(Hand.kLeft), 
          m_driverController.getBumperPressed(Hand.kLeft)));

// Configure the button bindings
    configureButtonBindings();

  }


  private void configureButtonBindings() {

//Left bumper controls the hopper
    new JoystickButton(m_operatorController, Button.kBumperLeft.value)
        .whenHeld(new HopperSpin(m_hopper, Constants.HOPPER_POWER_FORWARD))
        .whenReleased(new HopperSpin(m_hopper, 0.0));

    new JoystickButton(m_driverController, Button.kBumperLeft.value)
    .whenHeld(new Drive(m_drivetrain, () -> m_driverController.getTriggerAxis(GenericHID.Hand.kLeft),
    () -> m_driverController.getTriggerAxis(GenericHID.Hand.kRight),
    () ->  m_driverController.getX(Hand.kLeft), 
    true))
    .whenReleased(new Drive(m_drivetrain, () -> m_driverController.getTriggerAxis(GenericHID.Hand.kLeft),
    () -> m_driverController.getTriggerAxis(GenericHID.Hand.kRight),
    () ->  m_driverController.getX(Hand.kLeft), 
    false));

//Right bumper agitates hopper
    new JoystickButton(m_operatorController, Button.kBumperRight.value)
        .whenHeld(new AgitateHopper(m_hopper, Constants.HOPPER_POWER_REVERSE))
        .whenReleased(new AgitateHopper(m_hopper, 0.0));

//A button controls intake
    new JoystickButton(m_operatorController, Button.kA.value)
        .whenHeld(new IntakePowerCell(m_intake, Constants.INTAKE_SPEED))
        .whenReleased(new IntakePowerCell(m_intake, 0.0));

//Y button agitates intake
    new JoystickButton(m_operatorController, Button.kY.value)
        .whenHeld(new AgitateIntake(m_intake, Constants.OUTTAKE_SPEED))
        .whenReleased(new AgitateIntake(m_intake, 0.0));

//B button controls the shooter
    new JoystickButton(m_operatorController, Button.kB.value)
        .whenHeld(new ShootPowerCell(m_shooter, Constants.SHOOTER_POWER))
        .whenReleased(new InstantCommand(m_shooter::StopShooter, m_shooter)); 

/* ACTUAL CLIMBER CODE

//Back button sends the climbers up
    new JoystickButton(m_operatorController, Button.kBack.value)
        .whenHeld(new ClimbUp(m_climber, Constants.CLIMB_SPEED))
        .whenReleased(new ClimbUp(m_climber, 0.0));

//Start button brings the climbers down
    new JoystickButton(m_operatorController, Button.kStart.value)
        .whenHeld(new ClimbDown(m_climber, Constants.REVERSE_CLIMB_SPEED))
        .whenReleased(new ClimbDown(m_climber, 0.0)); */

//EXPERIMENTAL CLIMBER CODE

    new JoystickButton(m_operatorController, Button.kBack.value)
        .whenHeld(new ClimbWithEncoder(m_climber, Constants.CLIMB_SPEED, 100))
        .whenReleased(new ClimbWithEncoder(m_climber, 0, 0));

//Right joystick button brings the intake down
    new JoystickButton(m_operatorController, Button.kStickRight.value).whenPressed(new IntakeDown(m_intake));

//Left joystick burron sends the intake up
    new JoystickButton(m_operatorController, Button.kStickLeft.value).whenPressed(new IntakeUp(m_intake));

  }

    /*
    =========================================================================
                                AUTONOMOUS SELECTION
            //TODO: SELECT AN AUTONOMOUS COMMAND TO RUN BEFORE EACH MATCH
    =========================================================================
    */

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //This is the command that will be run in auton
    //Uncomment the command to be run and comment the others out
    //return m_basicAuton;
    //return m_basicAutonReverse;
    //return m_threeBallAuton;
    //return m_threeBallAutonEncoders;
    return m_testAuton;
 }
}
