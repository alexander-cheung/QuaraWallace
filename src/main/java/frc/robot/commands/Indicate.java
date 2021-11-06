package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Indicators;

public class Indicate extends CommandBase{
    private final Indicators indicators;
    private final Move move;

    public Indicate(Indicators mIndicators, Move mMove) {
        indicators = mIndicators;
        move = mMove;
    }

    @Override
    public void execute()
    {
        
    }

    public void update(int pin, int state) {

    }
}
