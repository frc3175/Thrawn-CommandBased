package frc.robot.autocommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class AutoIntakeDown extends CommandBase{

    private Intake m_intake;

    public AutoIntakeDown(Intake intake) {
        m_intake = intake;
        addRequirements(m_intake);
    }

    @Override
    public void execute() {
        m_intake.IntakeDown();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
