/* package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;

public class IntakePowerCell extends CommandBase {

    private final Intake m_intake;

    public IntakePowerCell(Intake intake) {
        m_intake = intake;
        addRequirements(m_intake);
    } 

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.IntakePowerCell(Constants.INTAKE_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true; //Should this be true or false?
  } 

    
    
} */