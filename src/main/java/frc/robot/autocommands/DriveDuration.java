package frc.robot.autocommands;

import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDuration extends AutoCommandBase {

    private Drivetrain m_drivetrain;
    private double m_power;
    private double m_seconds;

    Timer m_timer = new Timer();

    public DriveDuration(double timeOut, Drivetrain drivetrain, double power, double seconds) {
        super(timeOut);
        m_power = power;
        m_seconds = seconds;
        m_drivetrain = drivetrain;
    }

    @Override
    public void init() {
        m_timer.reset();
        m_timer.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void run() {
        if(m_timer.get() < m_seconds){
            m_drivetrain.Drive(m_power, 0, false);
        } else {
            m_drivetrain.Drive(0, 0, false);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end() {
        m_timer.stop();
        m_timer.reset();
    }

    @Override
    public String getCommandName() {
        return "DriveDuration";
    }


}
