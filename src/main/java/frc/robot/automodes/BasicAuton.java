package frc.robot.automodes;

//import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.autocommands.DriveDistance;
import frc.robot.subsystems.Drivetrain;

public class BasicAuton extends SequentialCommandGroup{

    private Drivetrain m_drivetrain;

    public BasicAuton(Drivetrain drivetrain) {
        m_drivetrain = drivetrain;
        addRequirements(m_drivetrain);

        addCommands(
            new DriveDistance(m_drivetrain, Constants.BASIC_AUTON_DRIVE_SPEED, 200)
        );

    }

}
