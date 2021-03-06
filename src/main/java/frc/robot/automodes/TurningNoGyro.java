package frc.robot.automodes;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class TurningNoGyro extends CommandBase{

    private Drivetrain m_drivetrain;
    private Shooter m_shooter;
    private Hopper m_hopper;
    private Intake m_intake;
    private Timer m_timer = new Timer();

    public TurningNoGyro(Drivetrain drivetrain, Shooter shooter, Hopper hopper, Intake intake) {
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
        m_intake.IntakeDown();
        m_drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        SmartDashboard.putNumber("Left Encoders: ", m_drivetrain.getEncoder());
        SmartDashboard.putNumber("Right Encoders: ", m_drivetrain.getRightEncoder());
        if(m_timer.get() < 4) {
            //do nothing
            m_drivetrain.resetEncoders();
        } else if(m_drivetrain.getEncoder() > -7500) {
            m_drivetrain.turnRight();
        } else if(m_drivetrain.getEncoder() > (-95113 - 7500)) {
            m_drivetrain.Drive(Constants.THREE_BALL_DRIVE_SPEED, 0, false);
            m_shooter.StopShooter();
            m_hopper.hopperPower(0);
        } else if(m_drivetrain.getRightEncoder() < 95113) {
            m_drivetrain.turnLeft();
        } else if(m_drivetrain.getRightEncoder() < 100113) {
            m_drivetrain.Drive(Constants.THREE_BALL_DRIVE_SPEED, 0, false);
        } else {
            m_drivetrain.stopRobot();
        }
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

    @Override 
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
