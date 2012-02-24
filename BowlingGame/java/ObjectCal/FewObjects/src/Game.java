import java.util.*;

public class Game {

	private final List<PinsKnockedDown> rolls = new ArrayList<PinsKnockedDown>();
	
	public void roll(PinsKnockedDown roll) {
		
		if (roll == null || rolls.size() == 22) 
			throw new IllegalArgumentException("cannot add a null roll or exceed 11 frames");
		
		rolls.add(roll);
		
		if (isRollStrike(roll))
			rolls.add(PinsKnockedDown.NONE);
	}

    private boolean isRollStrike(PinsKnockedDown roll) {
        return roll.equals(PinsKnockedDown.STRIKE) && rolls.size() % 2 == 1 && rolls.size() < 20;
    }

    public PinsKnockedDown score() {

        PinsKnockedDown total = PinsKnockedDown.NONE;
        List<Frame> frames = createFrames();

        for (int i = 0; i < 10; i++)
            total = total.add(Frame.score(frames.listIterator(i)));

        return total;
    }

    private List<Frame> createFrames() {

        PinsKnockedDown[] allRolls = rolls.toArray(new PinsKnockedDown[22]);
        List<Frame> frames = new ArrayList<Frame>();

        for (int i = 0; i < 22; i+=2)
            frames.add(new Frame(new PinsKnockedDown(allRolls[i]), new PinsKnockedDown(allRolls[i+1])));

        return frames;
    }
}
