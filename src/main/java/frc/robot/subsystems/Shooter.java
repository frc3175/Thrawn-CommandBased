package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;

import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    
    TalonFX m_shooter_motor = new TalonFX(Constants.TOP_SHOOTER_MOTOR);

    public Shooter() {
        m_shooter_motor.configFactoryDefault();
        m_shooter_motor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,
        Constants.PID_LOOP_IDX, 
        Constants.TIMEOUT_MS);

        m_shooter_motor.configNominalOutputForward(0, Constants.TIMEOUT_MS);
		m_shooter_motor.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
		m_shooter_motor.configPeakOutputForward(1, Constants.TIMEOUT_MS);
        m_shooter_motor.configPeakOutputReverse(-1, Constants.TIMEOUT_MS);
        
        m_shooter_motor.config_kF(Constants.PID_LOOP_IDX, Constants.GAINS_VELOCITY_F, Constants.TIMEOUT_MS);
        m_shooter_motor.config_kP(Constants.PID_LOOP_IDX, Constants.GAINS_VELOCITY_P, Constants.TIMEOUT_MS);
        m_shooter_motor.config_kI(Constants.PID_LOOP_IDX, Constants.GAINS_VELOCITY_I, Constants.TIMEOUT_MS);
        m_shooter_motor.config_kD(Constants.PID_LOOP_IDX, Constants.GAINS_VELOCITY_D, Constants.TIMEOUT_MS);


    }
  
    public void Shoot(double power) {

        double targetVelocity_UnitsPer100ms = power * 2000.0 * 2048.0 / 600.0;
        m_shooter_motor.set(TalonFXControlMode.Velocity, targetVelocity_UnitsPer100ms);

    }

}
