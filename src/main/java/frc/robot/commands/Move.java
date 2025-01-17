package frc.robot.commands;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveMode;
import frc.robot.subsystems.Drivetrain;

public class Move extends CommandBase {
  private double spdMult = Constants.defSpdMult;
  private double rotMult = Constants.defRotMult;
  private DriveMode driveMode = Constants.defDriveMode;
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
    // Switch speed 
    if(RobotContainer.joystick.getRawButtonPressed(8))
    {
      spdMult = 0.5;
      System.out.println(spdMult);
    }
    else if(RobotContainer.joystick.getRawButtonPressed(10))
    {
      spdMult = 0.7;
      System.out.println(spdMult);
    }
    else if(RobotContainer.joystick.getRawButtonPressed(12))
    {
      spdMult = 1.0;
      System.out.println(spdMult);
    }

    // Switch rotation speed 
    if(RobotContainer.joystick.getRawButtonPressed(7))
    {
      rotMult = -0.5;
      System.out.println(rotMult);
    }
    else if(RobotContainer.joystick.getRawButtonPressed(9))
    {
      rotMult = -0.75;
      System.out.println(rotMult);
    }
    else if(RobotContainer.joystick.getRawButtonPressed(11))
    {
      rotMult = -1;
      System.out.println(rotMult);
    }
    
    // Switch driveMode
    if (RobotContainer.xController.getAButtonPressed()) {
      if (driveMode == DriveMode.arcadeDrive) {
        driveMode = DriveMode.tankDrive;
        System.out.println("Switched to tankDrive");
      }
      else if (driveMode == DriveMode.tankDrive) {
        driveMode = DriveMode.arcadeDrive;
        System.out.println("Switched to arcadeDrive");
      }
    }

    // Calls a function to move the robot depending on the driveMode constant 
    if (driveMode == DriveMode.arcadeDrive) {
      double speed = RobotContainer.xController.getY(Constants.movementJoystick);
      double rotation = RobotContainer.xController.getX(Constants.movementJoystick);
      RobotContainer.myRobot.arcadeDrive(spdMult * speed, rotation * rotMult);
      //System.out.println("Speed: " + speed + " | Rotation: " + rotation + " | Speed Mult: " + spdMult);
    }
    else if (driveMode == DriveMode.tankDrive) {
      double left = RobotContainer.xController.getY(Hand.kLeft);
      double right = RobotContainer.xController.getY(Hand.kRight);
      RobotContainer.myRobot.tankDrive(spdMult * left,spdMult * right);
    }
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