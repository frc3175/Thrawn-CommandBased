package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

import frc.robot.Constants;

public class Shooter extends PIDSubsystem { 
    

    private final SpeedController m_shooter_motors = new SpeedControllerGroup(new WPI_TalonFX(Constants.TOP_SHOOTER_MOTOR), new WPI_TalonFX(Constants.BOTTOM_SHOOTER_MOTOR));
    private final SimpleMotorFeedforward m_shooterFeedforward =
      new SimpleMotorFeedforward(
          Constants.kSVolts, Constants.kVVoltSecondsPerRotation);

    public Shooter(PIDController m_shooter_pid) {
        super(new PIDController(Constants.kP, Constants.kI, Constants.kD));
        getController().setTolerance(Constants.SHOOTER_PID_TOLERANCE);
    }
   
    
    @Override
    public void useOutput(double output, double setpoint) {
        m_shooter_motors.setVoltage(output + m_shooterFeedforward.calculate(setpoint)); 
    }

    @Override
    protected double getMeasurement() {
        return 0; //WHAT GOES HERE??
    }

}
