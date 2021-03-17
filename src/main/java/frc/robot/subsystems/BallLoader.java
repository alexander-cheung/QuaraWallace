package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;


public class BallLoader extends SubsystemBase {
    public BallLoader()
    {

    }
    public void initialize(){
    RobotContainer.shooterServo.setRaw(0);
    // RobotContainer.joystick.toggleWhenActive(new Move(), true);
    } 

}
