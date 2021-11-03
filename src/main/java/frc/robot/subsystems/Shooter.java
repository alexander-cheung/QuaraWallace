package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Shooter extends SubsystemBase{
    public Shooter() {}

    public void initialize() {
        RobotContainer.shooterGroup.set(0);
        RobotContainer.v5.setInverted(InvertType.InvertMotorOutput);
    }

    @Override
    public void periodic() {
        RobotContainer.shoot.execute();
    }
}
