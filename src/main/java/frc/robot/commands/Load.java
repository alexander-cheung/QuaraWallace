package frc.robot.commands;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BallLoader;
import java.util.concurrent.TimeUnit;

public class Load extends CommandBase {

    public BallLoader loader;

    public Load(BallLoader mLoader) {
        loader = mLoader;
        addRequirements(mLoader);
    }

    @Override
    public void initialize() {
        RobotContainer.shooterServo.setRaw(0);
    }

    @Override
    public void execute() {
        if(RobotContainer.joystick.getRawButtonPressed(7)) {
            RobotContainer.shooterServo.setRaw(127);
            try {
                TimeUnit.SECONDS.sleep(1 / 3);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            RobotContainer.shooterServo.setRaw(0);
        }
    }

    public void end() {
        RobotContainer.shooterServo.stopMotor();;
    }


    
}
