package frc.robot.automodes;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.autocommands.DriveDistance;
import frc.robot.subsystems.Drivetrain;

public class BasicAutonReverse extends SequentialCommandGroup {

    private Drivetrain m_drivetrain;
    Timer m_timer = new Timer();

    public BasicAutonReverse(Drivetrain drivetrain) {
        m_drivetrain = drivetrain;
        addRequirements(m_drivetrain);

        addCommands(
            new DriveDistance(m_drivetrain, Constants.BASIC_AUTON_REVERSE_SPEED, 400)
        );

    }

    public void initialize() {
        m_timer.reset();
        m_timer.start();
    }

    public void execute() {
        //If time is more than initial timeout and less than drive time + timeout
        if(m_timer.get() > Constants.BASIC_TIMEOUT && m_timer.get() < (Constants.BASIC_DRIVE_TIME + Constants.BASIC_TIMEOUT)) {
            m_drivetrain.Drive(Constants.BASIC_AUTON_REVERSE_SPEED, 0, false); //Drive forward
        } else if(m_timer.get() < Constants.BASIC_TIMEOUT) { //If timer is less than timeout 
            m_drivetrain.Drive(0, 0, false); //Stop
        } else if(m_timer.get() > Constants.BASIC_DRIVE_TIME) { //If timer is greater than drive time
            m_drivetrain.Drive(0, 0, false); //Stop
        }
    }

    public void end(boolean interrupted) {
        m_timer.stop();
        m_timer.reset();
    }

    public boolean isFinished() {
        return false;
    }

}