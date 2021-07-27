package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
     
    private final TalonFX climber_motor = new TalonFX(Constants.CLIMBER_MOTOR);

    public void climbUp(double power) {
        climber_motor.setNeutralMode(NeutralMode.Brake);
        climber_motor.setInverted(false);
        climber_motor.set(ControlMode.PercentOutput, power);
    } 

    public void climbDown(double power) {
        climber_motor.setNeutralMode(NeutralMode.Brake);
        climber_motor.setInverted(true);
        climber_motor.set(ControlMode.PercentOutput, power);
    } 

}
