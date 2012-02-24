import java.util.ListIterator;

public class Frame {

	private final PinsKnockedDown firstRoll;
	private final PinsKnockedDown secondRoll;

	public Frame(PinsKnockedDown firstRoll, PinsKnockedDown secondRoll) {
		this.firstRoll = firstRoll;		
		this.secondRoll = secondRoll;
	}

	public static PinsKnockedDown score(ListIterator<Frame> frames) {
		Frame nextFrame = frames.next();

		PinsKnockedDown score = nextFrame.firstRoll.add(nextFrame.secondRoll);
		
		if (isSpare(nextFrame, score))
			score = score.add(spareBonus(frames));

		if (isStrike(nextFrame))
			score = score.add(strikeBonus(frames));
		
		return score;
	}

    private static boolean isSpare(Frame nextFrame, PinsKnockedDown score) {
        return !isStrike(nextFrame) && score.equals(PinsKnockedDown.STRIKE);
    }

    private static boolean isStrike(Frame nextFrame) {
        return nextFrame.firstRoll.equals(PinsKnockedDown.STRIKE);
    }

    private static PinsKnockedDown spareBonus(ListIterator<Frame> frames) {
		Frame nextFrame = frames.next();
		return nextFrame.firstRoll;
	}

	private static PinsKnockedDown strikeBonus(ListIterator<Frame> frames) {
		Frame nextFrame = frames.next();

		if (isTenthFrame(frames, nextFrame)) {
			Frame third = frames.next();
			return PinsKnockedDown.STRIKE.add(third.firstRoll);
		}

		return nextFrame.firstRoll.add(nextFrame.secondRoll);
	}

    private static boolean isTenthFrame(ListIterator<Frame> frames, Frame next) {
        return isStrike(next) && frames.hasNext();
    }
}
