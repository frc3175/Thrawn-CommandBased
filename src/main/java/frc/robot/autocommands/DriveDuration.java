package frc.robot.autocommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDuration extends CommandBase {

    private Drivetrain m_drivetrain;
    private double m_power;
    private double m_seconds;

    Timer m_timer = new Timer();

    public DriveDuration(Drivetrain drivetrain, double power, double seconds) {
        m_power = power;
        m_seconds = seconds;
        m_drivetrain = drivetrain;
        addRequirements(m_drivetrain);
    }

    @Override
    public void initialize() {
        m_timer.reset();
        m_timer.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(m_timer.get() < m_seconds){
            m_drivetrain.Drive(m_power, 0, false);
        } else {
            m_drivetrain.Drive(0, 0, false);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_timer.stop();
        m_timer.reset();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

}
