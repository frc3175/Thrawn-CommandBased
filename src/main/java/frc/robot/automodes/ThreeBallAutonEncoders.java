package frc.robot.automodes;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
//import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.autocommands.AutoShootAndHopper;
import frc.robot.autocommands.AutoShootDuration;
import frc.robot.autocommands.DriveDistance;
import frc.robot.commands.IntakeDown;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class ThreeBallAutonEncoders extends SequentialCommandGroup {

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

        addCommands(
            new IntakeDown(m_intake),
            new WaitCommand(3.0),
            new DriveDistance(m_drivetrain, Constants.THREE_BALL_DRIVE_SPEED, Constants.THREE_BALL_DRIVE_DISTANCE),
            new AutoShootDuration(m_shooter, Constants.THREE_BALL_SHOOT_SPEED, Constants.THREE_BALL_SPIN_UP),
            new AutoShootAndHopper(m_hopper, m_shooter, Constants.THREE_BALL_HOPPER_SPEED, Constants.THREE_BALL_SHOOT_SPEED, Constants.THREE_BALL_SPIN_UP, Constants.THREE_BALL_HOPPER_RUN),
            new InstantCommand(m_shooter::StopShooter, m_shooter)
        );

    }

/*
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
            if(m_drivetrain.getEncoder() > Constants.THREE_BALL_DRIVE_DISTANCE) {
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
*/

}