package frc.robot.automodes;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class ThreeBallAutonEncoders extends CommandBase{

    private Drivetrain m_drivetrain;
    private Shooter m_shooter;
    private Hopper m_hopper;
    private Intake m_intake;
    private Timer m_timer = new Timer();

    public ThreeBallAutonEncoders(Drivetrain drivetrain, Shooter shooter, Hopper hopper, Intake intake) {
        m_drivetrain = drivetrain;
        m_shooter = shooter;
        m_hopper = hopper;
        m_intake = intake;
        addRequirements(m_drivetrain, m_shooter, m_hopper);
    }

    @Override 
    public void initialize() {
        m_timer.reset();
        m_timer.start();
        m_drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        if(m_timer.get() < 3) {
            m_intake.IntakeDown();
        } else {
            if(m_drivetrain.getEncoder() > -94500) {
                SmartDashboard.putNumber("Encoders: ", m_drivetrain.getEncoder());
                m_drivetrain.Drive(Constants.THREE_BALL_DRIVE_SPEED, 0, false);
                m_shooter.StopShooter();
                m_hopper.hopperPower(0);
                m_timer.start();
            } else {
                m_drivetrain.Drive(0, 0, false);
            } 
            if(m_timer.get() > 3 && m_timer.get() < 7) {
                m_shooter.Shoot(Constants.SHOOTER_POWER);
                m_hopper.hopperPower(0);
            }else if(m_timer.get() > 7 && m_timer.get() < 12) {
                m_shooter.Shoot(Constants.SHOOTER_POWER);
                m_hopper.hopperPower(Constants.HOPPER_POWER_FORWARD);
            } else {
                m_drivetrain.stopRobot();
                m_shooter.StopShooter();
                m_hopper.hopperPower(0);
            } 
        }
    }

    @Override 
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}