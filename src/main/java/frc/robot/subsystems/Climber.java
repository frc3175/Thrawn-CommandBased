package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
     
    private final SpeedController left_climber = new WPI_TalonFX(Constants.LEFT_CLIMBER);

    public void climbUp(double power) {
        left_climber.setInverted(false);
        left_climber.set(power);
    } 

    public void climbDown(double power) {
        left_climber.setInverted(true);
        left_climber.set(power);
    } 

}
