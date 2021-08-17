package frc.robot.autocommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class AutoHopperSpin extends CommandBase{

    private Hopper m_hopper;
    private double m_seconds;
    private double m_power;

    Timer m_timer = new Timer();

    public AutoHopperSpin(Hopper hopper, double power, double seconds) {
        m_hopper = hopper;
        m_power = power;
        m_seconds = seconds;

        addRequirements(m_hopper);
    }

    @Override
    public void initialize() {
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        if(m_timer.get() < m_seconds){
            m_hopper.hopperPower(m_power);
        } else {
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
