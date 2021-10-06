package frc.robot.automodes;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class AutoWithTurnGyro extends CommandBase{

    private Drivetrain m_drivetrain;
    private Shooter m_shooter;
    private Hopper m_hopper;
    private Intake m_intake;
    private Timer m_timer = new Timer();
    private AHRS m_gyro = new AHRS();

    public AutoWithTurnGyro(Drivetrain drivetrain, Shooter shooter, Hopper hopper, Intake intake) {
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
        m_gyro.reset();
    }

    @Override
    public void execute() {
        if(m_timer.get() < 3) {
            m_intake.IntakeDown();
        } else {
            if(m_drivetrain.getEncoder() > -57500) {
                SmartDashboard.putNumber("Encoders: ", m_drivetrain.getEncoder());
                m_drivetrain.Drive(Constants.THREE_BALL_DRIVE_SPEED, 0, false);
                m_shooter.StopShooter();
                m_hopper.hopperPower(0);
                m_timer.start();
            } else if(m_gyro.getAngle() < 45){
                m_drivetrain.turnLeft();
            } else if(m_gyro.getAngle() > 45 && m_timer.get() < 4.6) {
                m_drivetrain.Drive(Constants.THREE_BALL_DRIVE_SPEED, 0, false);
            } else {
                m_drivetrain.stopRobot();
            }
            /*if(m_timer.get() > 6 && m_timer.get() < 10) {
                m_shooter.Shoot(Constants.SHOOTER_POWER);
                m_hopper.hopperPower(0);
            }else if(m_timer.get() > 10 && m_timer.get() < 15) {
                m_shooter.Shoot(Constants.SHOOTER_POWER);
                m_hopper.hopperPower(Constants.HOPPER_POWER_FORWARD);
            } else {
                m_drivetrain.stopRobot();
                m_shooter.StopShooter();
                m_hopper.hopperPower(0);
            } */
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