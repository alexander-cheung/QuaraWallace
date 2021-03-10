package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;
import java.util.concurrent.TimeUnit;

public class Shoot extends CommandBase {
    private double speed = 0;
    public Shooter shooter;

    public Shoot(Shooter mShooter) {
        shooter = mShooter;
        addRequirements(mShooter);
    }

    public void execute() {
        RobotContainer.shooterGroup.set(100);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            RobotContainer.shooterGroup.set(0);
            e.printStackTrace();
        }
        RobotContainer.shooterGroup.set(0);

    }

    public void end()
    {
        RobotContainer.shooterGroup.set(0);
    }
}
