package frc.robot.automodes;

import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class BasicAuton extends AutonMode {

    private Drivetrain m_drivetrain = new Drivetrain();
    
    public BasicAuton() {
        super();
    }

    @Override 
    public void run() {
        driveDuration(2, m_drivetrain, Constants.AUTON_DRIVE_SPEED, 2);
    }


}
