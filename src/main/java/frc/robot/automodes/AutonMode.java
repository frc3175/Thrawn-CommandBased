package frc.robot.automodes;

import frc.robot.autocommands.AutoCommandBase;
import frc.robot.autocommands.DriveDuration;
import frc.robot.subsystems.Drivetrain;

public abstract class AutonMode {

    public void start() {
        run();
    }

    protected abstract void run();
    
    protected void driveDuration(double timeOut, Drivetrain drivetrain, double power, double seconds) {
        runCommand(new DriveDuration(timeOut, drivetrain, power, seconds));
    }

    private void runCommand(AutoCommandBase command) {
        command.execute();
    }

}
