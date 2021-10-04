package frc.robot.autocommands;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDistance extends CommandBase {

    private Drivetrain m_drivetrain;
    private double m_power;
    private double m_encoderTicks;

    public DriveDistance(Drivetrain drivetrain, double power, double encoderTicks) {
        m_power = power;
        m_encoderTicks = encoderTicks;
        m_drivetrain = drivetrain;
        addRequirements(m_drivetrain);
    }

    @Override
    public void initialize() {
        m_drivetrain.resetEncoders();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        
            if(m_drivetrain.getEncoder() < m_encoderTicks) {
                m_drivetrain.Drive(m_power, 0, false);
            } else {
                m_drivetrain.Drive(0, 0, false);
            }

        //while(m_drivetrain.getEncoder() > m_encoderTicks) {
       //     m_drivetrain.stopRobot();
        //}

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }
}


