package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;
import frc.robot.RobotContainer;

public class AngleController extends SubsystemBase {
    public AngleController()
    {}

    public void initialize()
    {
        RobotContainer.controlActuator.set(0);
    }

    @Override
  public void periodic() {
    RobotContainer.aim.execute();
    // This method will be called once per scheduler run
  }
}
