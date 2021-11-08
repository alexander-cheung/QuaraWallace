package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class SpeedIndicator extends SubsystemBase {
  public SpeedIndicator() {}
 
  public void initialize() {
    RobotContainer.indicateSpeed.update(Constants.defSpdMult);
  }

  @Override
  public void periodic() {
    RobotContainer.indicateSpeed.execute();
  }
}