// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.util.function.DoubleSupplier;

import javax.swing.plaf.synth.SynthMenuBarUI;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_drivetrain;
  private final double m_leftTrigger;
  private final double m_rightTrigger;
  private final double m_speed;
  private final double m_rotation;
  private final boolean m_qt;

  
  public Drive(Drivetrain drivetrain, DoubleSupplier leftTrigger, DoubleSupplier rightTrigger, DoubleSupplier rotation, boolean qt) {
    m_drivetrain = drivetrain;
    m_leftTrigger = leftTrigger.getAsDouble();
    m_rightTrigger = rightTrigger.getAsDouble();
    m_rotation = rotation.getAsDouble();
    m_qt = qt;
    m_speed = 0;
/*
    if(m_leftTrigger > 0){ 
      m_speed = m_leftTrigger;
    }else if(m_rightTrigger > 0){
      m_speed = -m_rightTrigger;
    }else{
      m_speed = 0;
    }
*/

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }


// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.Drive(m_leftTrigger, m_rotation, m_qt);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
