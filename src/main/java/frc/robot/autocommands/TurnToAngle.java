package frc.robot.autocommands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TurnToAngle extends CommandBase{

    private double m_degreesToTurn;
    private Drivetrain m_drivetrain;
    private static AHRS m_gyro = new AHRS();
    private boolean m_turningRight;

    public TurnToAngle(Drivetrain drivetrain, double degreesToTurn, boolean turningRight) {
        m_drivetrain = drivetrain;
        m_degreesToTurn = degreesToTurn;
        addRequirements(m_drivetrain);
        m_turningRight = turningRight;
    }

    @Override
    public void initialize() {
        m_gyro.reset();
    }

    //TODO: figure out what the gyro does when going in a negative direction (left)
    @Override
    public void execute() {
        if(m_turningRight) {
            if(m_gyro.getAngle() < m_degreesToTurn) {
                m_drivetrain.Drive(0, 0.5, true);
            } else {
                m_drivetrain.Drive(0, 0, false);
            }
        } else {
            if((Math.abs(m_gyro.getAngle()) < m_degreesToTurn)) {
                m_drivetrain.Drive(0, -0.5, true);
            } else {
                m_drivetrain.Drive(0, 0, false);
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_gyro.reset();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
