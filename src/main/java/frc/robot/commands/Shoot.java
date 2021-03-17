package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;
import java.util.concurrent.TimeUnit;

public class Shoot extends CommandBase {
    private boolean on = false;
    public Shooter shooter;
    
    public Shoot(Shooter mShooter) {
        shooter = mShooter;
        addRequirements(mShooter);
    }
    @Override
    public void execute() {
        if(on)
        {
            on = false;
        }

        else
        {
            on = true;
        }
    }

    public void periodicCommand()
    {
        if(on)
        {
            RobotContainer.shooterGroup.set(100);
        }

        if(!on)
        {
            RobotContainer.shooterGroup.set(0);
        }
    }
    
    public void end()
    {
        RobotContainer.shooterGroup.set(0);
    }
}
