package frc.robot.automodes;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;

public class ThreeBallAuton extends CommandBase{

    private Drivetrain m_drivetrain;
    private Shooter m_shooter;
    private Hopper m_hopper;
    Timer m_timer = new Timer();

    public ThreeBallAuton(Drivetrain drivetrain, Shooter shooter, Hopper hopper) {
        m_drivetrain = drivetrain;
        m_shooter = shooter;
        m_hopper = hopper;
        addRequirements(m_drivetrain, m_shooter, m_hopper);
    }

    @Override 
    public void initialize() {
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        if(m_timer.get() < (Constants.THREE_BALL_TIMEOUT + Constants.THREE_BALL_INITIAL_DRIVE)) { //if timer is greater than timeout and less than timeout + drive
            m_drivetrain.Drive(Constants.THREE_BALL_DRIVE_SPEED, 0, false); //drive
        } else if(m_timer.get() < (Constants.THREE_BALL_TIMEOUT + Constants.THREE_BALL_INITIAL_DRIVE + Constants.THREE_BALL_SPIN_UP)) { //Otherwise, if it's less than that plus spin up time
            m_drivetrain.Drive(0, 0, false); //stop drivetrain
            m_shooter.Shoot(Constants.THREE_BALL_SHOOT_SPEED); //and spin up the shooter
        } else if(m_timer.get() < (Constants.THREE_BALL_TIMEOUT + Constants.THREE_BALL_INITIAL_DRIVE + Constants.THREE_BALL_SPIN_UP + Constants.THREE_BALL_HOPPER_RUN)) { //Otherwise, if it's less than that plus hopper time
            m_shooter.Shoot(Constants.THREE_BALL_SHOOT_SPEED); //keep the shooter going
            m_hopper.hopperPower(Constants.THREE_BALL_HOPPER_SPEED); //and start up the hopper
        } else { //but if it's greater than all of those
            m_shooter.StopShooter(); //stop the shooter
            m_hopper.hopperPower(0); //and stop the hopper
            m_drivetrain.Drive(0, 0, false); //and stop the drivetrain again just in case
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


