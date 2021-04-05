package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;
import java.util.concurrent.TimeUnit;

import com.ctre.phoenix.motorcontrol.InvertType;

public class Shoot extends CommandBase {
    private boolean on = false;
    public Shooter shooter;
    
    public Shoot(Shooter mShooter) {
        shooter = mShooter;
        addRequirements(mShooter);
    }
    @Override
    public void execute() {
        if(RobotContainer.joystick.getRawButtonPressed(6))
        {
            if(on)
            {
                on = false;
            }

            else
            {
                on = true;
            }

        }
        periodicCommand();
    }

    public void periodicCommand()
    {
        if(on)
        {
            RobotContainer.v5.set(100);
            RobotContainer.v6.set(100);
            
            
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
