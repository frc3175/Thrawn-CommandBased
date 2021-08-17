package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

//TODO: Fix this command
public class ClimbWithEncoder extends CommandBase{

    private Climber m_climber;
    private double m_climbSpeed;
    private double m_encoderTicks;
    private boolean isClimberUp;

    public ClimbWithEncoder(double climbSpeed) {
        m_climbSpeed = climbSpeed;
    }

    @Override
    public void initialize() {
        m_climber.resetEncoder();
    }

    @Override
    public void execute() {
        if(m_climber.getEncoderPosition() < m_encoderTicks) {

        }
    }

}
