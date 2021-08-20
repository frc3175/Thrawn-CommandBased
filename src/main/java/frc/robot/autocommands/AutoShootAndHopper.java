package frc.robot.autocommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;

public class AutoShootAndHopper extends CommandBase {

    private Hopper m_hopper;
    private Shooter m_shooter;
    private double m_hopperPower;
    private double m_shooterPower;
    private double m_spinUpTime;
    private double m_hopperSpinTime;

    Timer m_timer = new Timer();

    public AutoShootAndHopper(Hopper hopper, Shooter shooter, double hopperPower, double shooterPower, double spinUpTime, double hopperSpinTime) {
        m_hopper = hopper;
        m_shooter = shooter;
        m_hopperPower = hopperPower;
        m_shooterPower = shooterPower;
        m_spinUpTime = spinUpTime;
        m_hopperSpinTime = hopperSpinTime;
        addRequirements(m_hopper, m_shooter);
    }

    @Override
    public void initialize() {
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        if(m_timer.get() < m_spinUpTime) {
            m_shooter.Shoot(m_shooterPower);
        } else if(m_timer.get() < (m_spinUpTime + m_hopperSpinTime)) {
            m_shooter.Shoot(m_shooterPower);
            m_hopper.hopperPower(m_hopperPower);
        } else {
            m_shooter.StopShooter();
            m_hopper.hopperPower(0);
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
