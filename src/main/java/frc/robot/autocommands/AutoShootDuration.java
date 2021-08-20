package frc.robot.autocommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class AutoShootDuration extends CommandBase{

    private Shooter m_shooter;
    private double m_power;
    private double m_seconds;

    Timer m_timer = new Timer();

    public AutoShootDuration(Shooter shooter, double power, double seconds) {
        m_shooter = shooter;
        m_power = power;
        m_seconds = seconds;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        if(m_timer.get() < m_seconds) {
            m_shooter.Shoot(m_power); 
        } else {
            m_shooter.StopShooter();
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_timer.stop();
        m_timer.reset();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
