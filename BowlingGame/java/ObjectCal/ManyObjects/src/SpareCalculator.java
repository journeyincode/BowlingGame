public class SpareCalculator extends ScoreCalculator {
    private final Rolls rolls;

     public SpareCalculator(Rolls rolls) {
         this.rolls = rolls;
     }

    @Override
    public void updateScore(Score score, RollCount rollNumber) {
        if (isSpare(rollNumber) == TenPins.yes) {
            Score spareScore = spareScore(rollNumber);

            score.add(spareScore);
            rollNumber.add(new RollCount(2));

            updated();
        }
    }

    private TenPins isSpare(RollCount rollNumber) {
        return rolls.equalsTen(rollNumber, rollNumber.increment());
     }

    private Score spareScore(RollCount rollNumber) {
        Score spareScore = new Score(10);
        spareScore.add(spareBonus(rollNumber));

        return spareScore;
    }

    private Pins spareBonus(RollCount rollNumber) {
        return rolls.add(rollNumber.incrementByTwo(), null);
    }
}
