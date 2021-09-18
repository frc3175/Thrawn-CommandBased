// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

//import com.ctre.phoenix.motorcontrol.can.TalonFX;

//import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;

//hi


public class Drivetrain extends SubsystemBase {
 
/** Creates the Drive Subsystem */

  private final WPI_TalonFX left_front = new WPI_TalonFX(Constants.LEFT_FRONT_MOTOR);
  private final WPI_TalonFX left_back = new WPI_TalonFX(Constants.LEFT_BACK_MOTOR);
  private final WPI_TalonFX right_front = new WPI_TalonFX(Constants.RIGHT_FRONT_MOTOR);
  private final WPI_TalonFX right_back = new WPI_TalonFX(Constants.RIGHT_BACK_MOTOR);

  private final SpeedController m_leftDrive =
    new SpeedControllerGroup(left_front, left_back);
  private final SpeedController m_rightDrive =
    new SpeedControllerGroup(right_front, right_back);
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftDrive, m_rightDrive);


  public void Drive(double speed, double rotation, boolean qt){
      m_drive.curvatureDrive(speed, rotation, qt);
  }

  public void resetEncoders() {
    left_front.setSelectedSensorPosition(0);
    left_back.setSelectedSensorPosition(0);
    right_front.setSelectedSensorPosition(0);
    right_back.setSelectedSensorPosition(0);
  }

  public double getAverageEncoderPosition() {
    double total = (left_front.getSelectedSensorPosition() + left_back.getSelectedSensorPosition() + 
                   right_front.getSelectedSensorPosition() + right_back.getSelectedSensorPosition());
                   
    double average = total / 4;
    return average;
  }

  public double getEncoder() {
      return left_front.getSelectedSensorPosition();
  }

  public void stopRobot() {
    m_drive.curvatureDrive(0, 0, false);
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
