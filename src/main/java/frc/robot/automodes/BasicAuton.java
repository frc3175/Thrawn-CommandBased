package frc.robot.automodes;

//TODO: update basic auton and basic auton reverse to run with encoders

import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.autocommands.DriveDuration;
import frc.robot.subsystems.Drivetrain;

public class BasicAuton extends SequentialCommandGroup{

    private Drivetrain m_drivetrain;
    private Timer m_timer = new Timer();

    public BasicAuton(Drivetrain drivetrain) {
        m_drivetrain = drivetrain;
        addRequirements(m_drivetrain); 

        addCommands(
            new DriveDuration(m_drivetrain, Constants.BASIC_AUTON_DRIVE_SPEED, 2.0)
        );

    }

    @Override 
    public void initialize() {
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        if(m_timer.get() > 3) {
            m_drivetrain.Drive(Constants.BASIC_AUTON_DRIVE_SPEED, 0, false);
        } else {
            m_drivetrain.Drive(0, 0, false);
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
