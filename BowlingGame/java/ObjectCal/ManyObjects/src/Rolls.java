import java.util.*;

public class Rolls {
    private static final Pins TEN_PINS = new Pins(10);

    private SortedMap<RollCount, Pins> rolls = new TreeMap<RollCount, Pins>();

    public void put(RollCount currentRoll, Pins pinsDown) {
        rolls.put(currentRoll, pinsDown);
    }

    public Pins add(RollCount first, RollCount second) {
        Pins firstPins = getPins(first);
        Pins secondPins = getPins(second);

        firstPins.add(secondPins);
        return firstPins;
    }

    private Pins getPins(RollCount rollNumber) {
        if (rollNumber == null || !rolls.containsKey(rollNumber))
            return new Pins(0);

        Pins pins = rolls.get(rollNumber);
        return Pins.copyPins(pins);
    }

    public TenPins equalsTen(RollCount rollNumber) {
        Pins pins = rolls.get(rollNumber);
        return isTenPins(pins);
    }

    public TenPins equalsTen(RollCount first, RollCount second) {
        Pins total = add(first, second);
        return isTenPins(total);
    }

    private TenPins isTenPins(Pins pins) {
        if (pins.equals(TEN_PINS))
            return TenPins.yes;

        return TenPins.no;
    }
}
