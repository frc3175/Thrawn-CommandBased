package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakePowerCell extends CommandBase {

    double m_intake_speed;

    private final Intake m_intake;

    public IntakePowerCell(Intake intake, Double intake_speed) {
        m_intake_speed = intake_speed;
        m_intake = intake;
        addRequirements(m_intake);
    } 

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.IntakePowerCell(m_intake_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true; //Should this be true or false?
  } 

    
    
}
