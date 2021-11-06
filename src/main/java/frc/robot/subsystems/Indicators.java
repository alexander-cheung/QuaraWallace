package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Indicators extends SubsystemBase {
  public Indicators() {}
 
  public void initialize() {
  }

  // This method will be called once per scheduler run
  @Override
  public void periodic() {
    RobotContainer.indicate.execute();
  }
}
