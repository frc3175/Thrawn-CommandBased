/* package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import frc.robot.Constants;


public class Intake extends SubsystemBase {

    private final SpeedController m_intake = new WPI_TalonSRX(Constants.INTAKE_FALCON);
    private final DoubleSolenoid m_Solenoid = new DoubleSolenoid(Constants.LEFT_SOLENOID, Constants.RIGHT_SOLENOID);

    public void IntakeUp () {
        m_Solenoid.set(kForward);
    }

    public void IntakeDown () {
        m_Solenoid.set(kReverse);
    }

    public void IntakePowerCell (double power) {
        m_intake.setInverted(false);
        m_intake.set(power);
    }

    public void OuttakePowerCell (double reversepower) {
        m_intake.setInverted(true);
        m_intake.set(reversepower);
    }
    
} */
