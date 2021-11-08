package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class RotationIndicator extends SubsystemBase {
  public RotationIndicator() {}
 
  public void initialize() {
    RobotContainer.indicateRotation.update(Constants.defRotMult);
  }
  
  @Override
  public void periodic() {
    RobotContainer.indicateRotation.execute();
  }
}
