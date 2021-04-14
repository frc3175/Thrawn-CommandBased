package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hopper;

public class HopperSpin extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private final Hopper m_hopper;
    
    public HopperSpin(Hopper hopper) {
        m_hopper = hopper;

        addRequirements(m_hopper);
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_hopper.hopperPower(Constants.HOPPER_POWER_FORWARD);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   // m_hopper.hopperPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true; //Should this be true or false?
  } 

}


