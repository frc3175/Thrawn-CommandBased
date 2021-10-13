package frc.robot.automodes;

//TODO: update basic auton and basic auton reverse to run with encoders

import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.autocommands.DriveDistance;
import frc.robot.commands.IntakeDown;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;

public class BasicAuton extends SequentialCommandGroup{

    private Drivetrain m_drivetrain;
    private Intake m_intake;
    private Timer m_timer = new Timer();

    public BasicAuton(Drivetrain drivetrain, Intake intake) {
        m_drivetrain = drivetrain;
        m_intake = intake;
        addRequirements(m_drivetrain); 

        addCommands(
            new IntakeDown(m_intake),
            new DriveDistance(m_drivetrain, Constants.BASIC_AUTON_DRIVE_SPEED, Constants.BASIC_AUTON_DISTANCE)
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
