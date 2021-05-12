package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShootPowerCell extends CommandBase {

    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    double m_shoot_speed;
    private final Shooter m_shooter;
    double m_shooter_setpoint;

    public ShootPowerCell(Shooter shooter, double shoot_speed) {

        m_shooter = shooter;
        m_shoot_speed = shoot_speed;

        addRequirements(m_shooter);
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.Shoot(m_shoot_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //m_shooter.useOutput(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //m_shooter.useOutput(0, 0);
    return true;
  } 

}
