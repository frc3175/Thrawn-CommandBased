// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.util.function.DoubleSupplier;

//import javax.swing.plaf.synth.SynthMenuBarUI;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_drivetrain;
  private final DoubleSupplier m_leftTrigger;
  private final DoubleSupplier m_rightTrigger;
  private final DoubleSupplier m_rotation;
  private final boolean m_qt;

  
  public Drive(Drivetrain drivetrain, DoubleSupplier leftTrigger, DoubleSupplier rightTrigger, DoubleSupplier rotation, boolean qt) {
    m_drivetrain = drivetrain;
    m_leftTrigger = leftTrigger;
    m_rightTrigger = rightTrigger;
    m_rotation = rotation;
    m_qt = qt; 

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }


// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //double joystickTurnSpeed = m_rotation.getAsDouble();
    double turnSpeedMod;
    double leftTriggerInput = m_leftTrigger.getAsDouble();
    double leftTriggerInputMod;
    double rightTriggerInput = m_rightTrigger.getAsDouble();
    double rightTriggerInputMod;

    if(m_leftTrigger.getAsDouble() > 0) {
      turnSpeedMod = m_rotation.getAsDouble() * -1 * 0.6;
    } else {
      turnSpeedMod = m_rotation.getAsDouble() * 0.6;
    } //hi

    leftTriggerInputMod = leftTriggerInput * leftTriggerInput;
    rightTriggerInputMod = rightTriggerInput * rightTriggerInput;


    m_drivetrain.Drive((leftTriggerInputMod - rightTriggerInputMod), (turnSpeedMod * -1), m_qt); 
  }

  // Called once the command enlds or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}





  

  /* Old execute method (before reverse turning was fixed and joystick inputs were squared) 
    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.Drive((m_leftTrigger.getAsDouble() - m_rightTrigger.getAsDouble()), -m_rotation.getAsDouble(), m_qt);
  } */
