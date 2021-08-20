package frc.robot.automodes;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;

public class ThreeBallAutonEncoders extends CommandBase{

    private Drivetrain m_drivetrain;
    private Shooter m_shooter;
    private Hopper m_hopper;

    public ThreeBallAutonEncoders(Drivetrain drivetrain, Shooter shooter, Hopper hopper) {
        m_drivetrain = drivetrain;
        m_shooter = shooter;
        m_hopper = hopper;
        addRequirements(m_drivetrain, m_shooter, m_hopper);
    }

    @Override 
    public void initialize() {
        m_drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        if(m_drivetrain.getAverageEncoderPosition() < 200) {
            m_drivetrain.Drive(Constants.THREE_BALL_DRIVE_SPEED, 0, false);
            m_shooter.Shoot(0.5);
        } else if(m_drivetrain.getAverageEncoderPosition() > 200) {
            m_drivetrain.stopRobot();
            m_shooter.StopShooter();
            m_hopper.hopperPower(0);
        }
    }

    @Override 
    public void end(boolean interrupted) {
        m_drivetrain.resetEncoders();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}