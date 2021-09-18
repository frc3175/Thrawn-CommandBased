package frc.robot.automodes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.autocommands.AutoShootAndHopper;
import frc.robot.autocommands.DriveDuration;
import frc.robot.commands.IntakeDown;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class TestAutonDuration extends SequentialCommandGroup{

    private Drivetrain m_drivetrain;
    private Shooter m_shooter;
    private Hopper m_hopper;
    private Intake m_intake;

    public TestAutonDuration(Drivetrain drivetrain, Shooter shooter, Hopper hopper, Intake intake) {
        m_drivetrain = drivetrain;
        m_shooter = shooter;
        m_hopper = hopper;
        m_intake = intake;
        addRequirements(m_drivetrain, m_shooter, m_hopper);

        addCommands(
            new IntakeDown(m_intake),
            new WaitCommand(2),
            new DriveDuration(m_drivetrain, Constants.THREE_BALL_DRIVE_SPEED, 1.3),
            new WaitCommand(0.5),
            new AutoShootAndHopper(m_hopper, m_shooter, 1, Constants.THREE_BALL_SHOOT_SPEED, 3, 3)
        );

    }

}