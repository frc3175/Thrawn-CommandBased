package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
     
    private final SpeedController climber_motor = new WPI_TalonFX(Constants.CLIMBER_MOTOR);

    public void climbUp(double power) {
        climber_motor.setInverted(false);
        climber_motor.set(power);
    } 

    public void climbDown(double power) {
        climber_motor.setInverted(true);
        climber_motor.set(power);
    } 

}
