package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class AgitateIntake extends CommandBase {

    double m_outtake_speed;

    private final Intake m_intake;

    public AgitateIntake(Intake intake, Double outtake_speed) {
        m_outtake_speed = outtake_speed;
        m_intake = intake;
        addRequirements(m_intake);
    } 


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.OuttakePowerCell(m_outtake_speed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  } 

    
}
