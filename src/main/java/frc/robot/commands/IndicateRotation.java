package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DigitalOutput;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.RotationIndicator;

public class IndicateRotation extends CommandBase{
    private final RotationIndicator indicator;
    private final Move move;
    private DigitalOutput[] leds;

    public IndicateRotation(RotationIndicator mIndicator, Move mMove) {
        indicator = mIndicator;
        move = mMove;
        leds = new DigitalOutput[Constants.rotationIndicatorPins.length];
        for(int i = 0; i < Constants.rotationIndicatorPins.length; i++) {
            leds[i] = new DigitalOutput(Constants.rotationIndicatorPins[i]);
        }
    }

    @Override
    public void execute() {
        update(move.rotMult);
    }

    public void update(double rotMult) {
        resetLeds();
        for(int i = 0; i < Constants.rotSpeeds.length; i++) {
            if (rotMult == Constants.rotSpeeds[i]) {
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
