package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeUpAndDown extends CommandBase{
   
    private Intake m_intake;
    boolean isIntakeUp = true;

    public IntakeUpAndDown(Intake intake) {
        m_intake = intake;
        addRequirements(m_intake);
    }

    @Override
    public void execute() {
       if(isIntakeUp) {
           m_intake.IntakeDown();
           isIntakeUp = false;
       } else if(!isIntakeUp) {
           m_intake.IntakeUp();
           isIntakeUp = true;
       }
    }

}
