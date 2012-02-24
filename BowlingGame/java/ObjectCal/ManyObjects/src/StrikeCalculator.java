public class StrikeCalculator extends ScoreCalculator {
    private final Rolls rolls;

    public StrikeCalculator(Rolls rolls) {
        this.rolls = rolls;
    }

    @Override
    public void updateScore(Score score, RollCount rollNumber) {
         if (isStrike(rollNumber) == TenPins.yes) {
            Score strikeScore = strikeScore(rollNumber);

            score.add(strikeScore);
            rollNumber.add(new RollCount(1));

            updated();
        }
    }

    private TenPins isStrike(RollCount rollNumber) {
        return rolls.equalsTen(rollNumber);
    }

    private Score strikeScore(RollCount rollNumber) {
        Score strikeScore = new Score(10);
        strikeScore.add(strikeBonus(rollNumber));

        return strikeScore;
    }

    private Pins strikeBonus(RollCount rollNumber) {
        return rolls.add(rollNumber.increment(), rollNumber.incrementByTwo());
    }
}
