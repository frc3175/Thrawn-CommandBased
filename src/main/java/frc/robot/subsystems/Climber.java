package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
     
    private final SpeedController climber_motors = 
        new SpeedControllerGroup(new WPI_TalonFX(Constants.LEFT_CLIMBER), new WPI_TalonFX(Constants.RIGHT_CLIMBER));

    public void climbUp(double power) {
        climber_motors.setInverted(false);
        climber_motors.set(power);
    } 

    public void climbDown(double power) {
        climber_motors.setInverted(true);
        climber_motors.set(power);
    } 

}
