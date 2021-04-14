package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;

public class Hopper extends SubsystemBase {
    
    private final SpeedController m_hopper = new WPI_TalonSRX(Constants.HOPPER_TALON);


    public void hopperPower(double power) {
        m_hopper.setInverted(true);
        m_hopper.set(power);
    }

    public void reverseHopperPower(double power){
        m_hopper.setInverted(false);
        m_hopper.set(power);
    }

}
