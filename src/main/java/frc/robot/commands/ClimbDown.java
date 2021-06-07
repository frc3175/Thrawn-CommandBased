package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ClimbDown extends CommandBase{
    
    double m_climb_speed;
    private final Climber m_climber;

    public ClimbDown(Climber climber, Double climb_speed) {
        m_climber = climber;
        m_climb_speed = climb_speed;

        addRequirements(m_climber);
    }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_climber.climbDown(m_climb_speed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  } 

}
