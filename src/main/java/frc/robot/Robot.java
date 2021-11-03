// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.simulation.JoystickSim;
import frc.robot.subsystems.*;
import frc.robot.commands.Move;
import frc.robot.commands.Shoot;
import frc.robot.commands.Load;
import frc.robot.commands.Aim;
import frc.robot.commands.Cancel;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    RobotContainer.xController = new XboxController(1);
    RobotContainer.drivetrain = new Drivetrain();
    RobotContainer.shooter = new Shooter();
    RobotContainer.ballLoader = new BallLoader();
    RobotContainer.angleController = new AngleController();
    RobotContainer.joystick = new Joystick(Constants.joystick);
    RobotContainer.v1 = new WPI_VictorSPX(Constants.RightLeader);
    RobotContainer.v2 = new WPI_VictorSPX(Constants.LeftLeader);
    RobotContainer.v3 = new WPI_VictorSPX(Constants.RightFollower);
    RobotContainer.v4 = new WPI_VictorSPX(Constants.LeftFollower);
    RobotContainer.v5 = new WPI_VictorSPX(5);
    RobotContainer.v6 = new WPI_VictorSPX(2);
    RobotContainer.shooterServo = new PWM(3);
    RobotContainer.controlActuator = new Servo(0);
    RobotContainer.rightGroup = new SpeedControllerGroup(RobotContainer.v1, RobotContainer.v3);
    RobotContainer.leftGroup = new SpeedControllerGroup(RobotContainer.v2, RobotContainer.v4);
    RobotContainer.shooterGroup = new SpeedControllerGroup(RobotContainer.v5, RobotContainer.v6);
    RobotContainer.myRobot = new DifferentialDrive(RobotContainer.leftGroup, RobotContainer.rightGroup);
    RobotContainer.drivetrain.initialize();
    RobotContainer.shooter.initialize();
    RobotContainer.ballLoader.initialize();
    RobotContainer.angleController.initialize();
    RobotContainer.move = new Move(RobotContainer.drivetrain);
    RobotContainer.shoot = new Shoot(RobotContainer.shooter);
    RobotContainer.load = new Load(RobotContainer.ballLoader);
    RobotContainer.aim = new Aim(RobotContainer.angleController);
    RobotContainer.xButtonShooter = new JoystickButton(RobotContainer.xController, Constants.shootButton);
    RobotContainer.xButtonLoader = new JoystickButton(RobotContainer.xController, Constants.loadButton);
      m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    System.out.println("a");
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  
  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
