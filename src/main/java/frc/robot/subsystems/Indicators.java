package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Indicators extends SubsystemBase {
  public Indicators() {}
 
  public void initialize() {
    RobotContainer.myRobot.tankDrive(0, 0);
  }

  // This method will be called once per scheduler run
  @Override
  public void periodic() {
    RobotContainer.move.execute();
  }
}
