public class FrameCalculator extends ScoreCalculator {
    private final Rolls rolls;

    public FrameCalculator(Rolls rolls) {
        this.rolls = rolls;
    }

    @Override
    public void updateScore(Score score, RollCount rollNumber) {
        Score frameScore = frameScore(rollNumber);

        score.add(frameScore);
        rollNumber.add(new RollCount(2));

        updated();
    }

    private Score frameScore(RollCount rollNumber) {
        Score frameScore = new Score(0);
        frameScore.add(rollFrame(rollNumber));

        return frameScore;
    }

    private Pins rollFrame(RollCount rollNumber) {
        return rolls.add(rollNumber, rollNumber.increment());
    }
}