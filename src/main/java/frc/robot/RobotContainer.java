// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import javax.swing.event.AncestorEvent;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Joystick joystick;
  public static XboxController xController;
  public static DifferentialDrive myRobot;
  public static Drivetrain drivetrain;
  public static Shooter shooter;
  public static BallLoader ballLoader;
  public static AngleController angleController;
  public static SpeedIndicator speedIndicator;
  public static RotationIndicator rotationIndicator;
  public static Move move;
  public static Cancel cancel;
  public static Shoot shoot;
  public static Load load;
  public static Aim aim;
  public static IndicateSpeed indicateSpeed;
  public static IndicateRotation indicateRotation;
  public static WPI_VictorSPX v1;
  public static WPI_VictorSPX v2;
  public static WPI_VictorSPX v3;
  public static WPI_VictorSPX v4;
  public static WPI_VictorSPX v5;
  public static WPI_VictorSPX v6;
  public static PWM shooterServo;
  public static Servo controlActuator;
  public static SpeedControllerGroup rightGroup;
  public static SpeedControllerGroup leftGroup;
  public static SpeedControllerGroup shooterGroup;
  public static JoystickButton xButtonShooter;
  public static JoystickButton xButtonLoader;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    xButtonShooter.whenPressed(shoot, false);
    xButtonLoader.whenPressed(load, false);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
 
}
