// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;


public class Drivetrain extends SubsystemBase {
 
/** Creates the Drive Subsystem */


  private final SpeedController m_leftDrive =
      new SpeedControllerGroup(new WPI_TalonFX(Constants.LEFT_FRONT_MOTOR), new WPI_TalonFX(Constants.LEFT_BACK_MOTOR));
  private final SpeedController m_rightDrive =
      new SpeedControllerGroup(new WPI_TalonFX(Constants.RIGHT_FRONT_MOTOR), new WPI_TalonFX(Constants.RIGHT_BACK_MOTOR));
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftDrive, m_rightDrive);

  public void Drive(double speed, double rotation, boolean qt){
      m_drive.curvatureDrive(speed, rotation, qt);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
