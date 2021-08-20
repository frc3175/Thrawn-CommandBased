package frc.robot.autocommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class AutoShootRotations extends CommandBase{

    private Shooter m_shooter;
    private double m_power;
    private double m_encoderTicks;

    public AutoShootRotations(Shooter shooter, double power, double encoderTicks) {
        m_power = power;
        m_encoderTicks = encoderTicks;
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        m_shooter.resetEncoders();
    }

    @Override
    public void execute() {
        if(m_shooter.getEncoderPosition() < m_encoderTicks) {
            m_shooter.Shoot(m_power);
        } else {
            m_shooter.StopShooter();
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_shooter.resetEncoders();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
