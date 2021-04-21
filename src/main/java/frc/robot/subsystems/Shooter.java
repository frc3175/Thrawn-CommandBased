package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

import frc.robot.Constants;

public class Shooter /* extends PIDSubsystem */ { //Make sure to uncomment "extends PIDSubsystem eventually"!!!!!!!!
    
    private final SpeedController m_shooter_motors = new SpeedControllerGroup(new WPI_TalonFX(Constants.TOP_SHOOTER_MOTOR), new WPI_TalonFX(Constants.BOTTOM_SHOOTER_MOTOR));

}
