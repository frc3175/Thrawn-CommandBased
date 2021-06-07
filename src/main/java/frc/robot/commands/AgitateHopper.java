package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class AgitateHopper extends CommandBase {
    
    double m_hopper_speed;

    private final Hopper m_hopper;
    
    public AgitateHopper(Hopper hopper, Double hopper_speed) {
        m_hopper = hopper;
        m_hopper_speed = hopper_speed;

        addRequirements(m_hopper);
    }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_hopper.reverseHopperPower(m_hopper_speed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  } 

}
