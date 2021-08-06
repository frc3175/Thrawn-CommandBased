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
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Climber;
import frc.robot.commands.AgitateHopper;
import frc.robot.commands.AgitateIntake;
import frc.robot.commands.ClimbDown;
/*import frc.robot.commands.IntakeDown;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.IntakePowerCell; */

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
 // private final Intake m_intake = new Intake();
  XboxController m_driverController = new XboxController(0);
  XboxController m_operatorController = new XboxController(1);
 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
      m_drivetrain.setDefaultCommand( 
      new Drive( 
          m_drivetrain,
          () -> m_driverController.getTriggerAxis(GenericHID.Hand.kLeft),
          () -> m_driverController.getTriggerAxis(GenericHID.Hand.kRight),
          () ->  m_driverController.getX(Hand.kLeft), 
          m_driverController.getBumper(Hand.kLeft)));

              // Configure the button bindings
    configureButtonBindings();

    

  }

  /** 
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(m_operatorController, Button.kBumperLeft.value)
        .whenHeld(new HopperSpin(m_hopper, Constants.HOPPER_POWER_FORWARD))
        .whenReleased(new HopperSpin(m_hopper, 0.0));

    new JoystickButton(m_operatorController, Button.kX.value)
        .whenPressed(new IntakePowerCell(m_intake, Constants.INTAKE_SPEED))
        .whenReleased(new IntakePowerCell(m_intake, 0.0));

    new JoystickButton(m_operatorController, Button.kB.value)
        .whenHeld(new ShootPowerCell(m_shooter, Constants.SHOOTER_POWER))
        .whenReleased(new InstantCommand(m_shooter::StopShooter, m_shooter)); 
        
    new JoystickButton(m_operatorController, Button.kBack.value)
        .whenHeld(new ClimbUp(m_climber, Constants.CLIMB_SPEED))
        .whenReleased(new ClimbUp(m_climber, 0.0));
    
    new JoystickButton(m_operatorController, Button.kStart.value)
        .whenHeld(new ClimbDown(m_climber, Constants.REVERSE_CLIMB_SPEED))
        .whenReleased(new ClimbDown(m_climber, 0.0));

    /*new JoystickButton(m_operatorController, Button.kY.value)
        .whenHeld(new AgitateIntake(m_intake, Constants.OUTTAKE_SPEED))
        .whenReleased(new AgitateIntake(m_intake, 0.0));

    new JoystickButton(m_operatorController, Button.kA.value)
        .whenHeld(new AgitateHopper(m_hopper, Constants.HOPPER_POWER_REVERSE))
        .whenReleased(new AgitateHopper(m_hopper, 0.0)); */
    
    new JoystickButton(m_operatorController, Button.kA.value).whenPressed(new IntakeUp(m_intake));
    new JoystickButton(m_operatorController, Button.kY.value).whenPressed(new IntakeDown(m_intake));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
   return null;
 }
}
