package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Shooter extends SubsystemBase{
    public Shooter()
    {

    }

    public void initialize()
    {
        RobotContainer.shooterGroup.set(0);
    }
    @Override
    public void periodic()
    {
        
    }
}
