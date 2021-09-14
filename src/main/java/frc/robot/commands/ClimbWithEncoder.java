package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

//TODO: Fix this command
public class ClimbWithEncoder extends CommandBase{

    private Climber m_climber;
    private double m_climbSpeed;
    private double m_encoderTicks;

    public ClimbWithEncoder(Climber climber, double climbSpeed, int encoderTicks) {
        m_climbSpeed = climbSpeed;
        m_climber = climber;
        m_encoderTicks = encoderTicks;
        addRequirements(m_climber);
    }

    @Override
    public void initialize() {
        m_climber.resetEncoder();
    }

    @Override
    public void execute() {
        if(m_climber.getEncoderPosition() < m_encoderTicks) {
            m_climber.climbUp(m_climbSpeed);
        } else if(m_climber.getEncoderPosition() < (m_encoderTicks + m_encoderTicks)) {
            m_climber.climbDown(m_climbSpeed);
        } else {
            m_climber.climbUp(0);
        }
    }

}
