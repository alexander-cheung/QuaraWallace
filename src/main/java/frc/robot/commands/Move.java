package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class Move extends CommandBase {
  private double spdMult = 0.7;
  public Drivetrain drivetrain;
  public Move(Drivetrain mDrivetrain) {
    drivetrain = mDrivetrain;
    addRequirements(mDrivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.joystick.getRawButtonPressed(8))
    {
      spdMult = 0.5;
    }
    else if(RobotContainer.joystick.getRawButtonPressed(10))
    {
      spdMult = 0.7;
    }
    else if(RobotContainer.joystick.getRawButtonPressed(12))
    {
      spdMult = 1.0;
    }
    RobotContainer.myRobot.tankDrive(-spdMult*RobotContainer.xController.getY(Hand.kLeft),-spdMult*RobotContainer.xController.getY(Hand.kRight));
  }

  // Called once the command ends or is interrupted.
  public void end() {
    RobotContainer.myRobot.tankDrive(0, 0);
  }

  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}