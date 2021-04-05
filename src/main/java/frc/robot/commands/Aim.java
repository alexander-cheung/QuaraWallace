package frc.robot.commands;

import java.util.spi.ResourceBundleProvider;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

import frc.robot.subsystems.AngleController;

public class Aim extends CommandBase{
    public AngleController mAngleController;
    public Aim(AngleController aController)
    {
        mAngleController = aController;
        addRequirements(aController);
    }
    @Override
    public void initialize() {
    }
    @Override
  public void execute() {
      double factor = RobotContainer.joystick.getY();

      RobotContainer.controlActuator.set(RobotContainer.controlActuator.get() + 0.005 * factor);
  }
}
