// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import java.util.HashMap;
import java.util.LinkedHashMap;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    // Ports for components 
    public static final int RightLeader = 0;
    public static final int RightFollower = 3;
    public static final int LeftLeader = 1;
    public static final int LeftFollower = 4;
    public static final int joystick = 0;
    // Add pin number(s) for speed lights 
    // Add pin number(s) for rotation lights 

    // Buttons from the joystick 
    public static final int shootButton = 5;
    public static final int loadButton = 6;
 
    public enum DriveMode {
        tankDrive,
        arcadeDrive;
    }
    // The default driving mode 
    public static final DriveMode defDriveMode = DriveMode.arcadeDrive;
    // Which joystick is used for arcade drive (left or right)
    public static final Hand movementJoystick = Hand.kLeft;
    // The default speed multiplier 
    public static final double defSpdMult = 0.75;
    // The default rotation multiplier 
    public static final double defRotMult = -0.75;

    // The buttons used to change movement speed from the joystick
    public static final int[] movButtons = {8, 10, 12};
    // The multipliers that the buttons will apply to movement speed
    public static final double[] movSpeeds = {0.5, 0.7, 1.0};
    // The buttons used to change rotation speed from the joystick 
    public static final int[] rotButtons = {7, 9, 11};
    // the multipliers that the buttons will apply to rotation speed
    public static final double[] rotSpeeds = {-0.5, -0.75, -1};
}
