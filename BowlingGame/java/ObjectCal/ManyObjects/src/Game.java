public class Game {
    private RollCount currentRoll = new RollCount(0);
    private Rolls rolls = new Rolls();

    public void roll(Pins pinsDown) {
        currentRoll = currentRoll.increment();
        rolls.put(currentRoll, pinsDown);
    }

    public Score score() {
        Score score = new Score(0);
        RollCount rollNumber = new RollCount(1);

        ScoreCalculator calculator = initChain();

        for (int frame = 0; frame < 10; frame++) {
            calculator.run(score, rollNumber);
        }

        return score;
    }

    private ScoreCalculator initChain() {
        ScoreCalculator frameCalculator = new FrameCalculator(rolls);

        ScoreCalculator spareCalculator = new SpareCalculator(rolls);
        spareCalculator.next(frameCalculator);

        ScoreCalculator strikeCalculator = new StrikeCalculator(rolls);
        strikeCalculator.next(spareCalculator);

        return strikeCalculator;
    }
}
