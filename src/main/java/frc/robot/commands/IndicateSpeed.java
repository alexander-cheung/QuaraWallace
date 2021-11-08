package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DigitalOutput;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SpeedIndicator;

public class IndicateSpeed extends CommandBase{
    private final SpeedIndicator indicator;
    private final Move move;
    private DigitalOutput[] leds;

    public IndicateSpeed(SpeedIndicator mIndicator, Move mMove) {
        indicator = mIndicator;
        move = mMove;
    }

    @Override
    public void execute() {
        update(move.spdMult);
    }

    public void update(double spdMult) {
        for(int i = 0; i < Constants.movSpeeds.length; i++) {
            if (spdMult == Constants.movSpeeds[i]) {
                resetLeds();
                leds[i].set(true);
                break;
            }
        }
    }

    private void resetLeds() {
        for (DigitalOutput led : leds) {
            led.set(false);
        }
    }
}
