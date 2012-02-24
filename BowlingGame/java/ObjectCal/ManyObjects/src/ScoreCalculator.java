public abstract class ScoreCalculator {
    private ScoreCalculator successor;
    private boolean updated = false;

    public void next(ScoreCalculator successor) {
        this.successor = successor;
    }

    public void run(Score score, RollCount rollNumber) {
        updated = false;

        updateScore(score, rollNumber);

        if (successor != null && !updated)
            successor.run(score, rollNumber);
    }

    protected void updated() {
        updated = true;
    }

    protected abstract void updateScore(Score score, RollCount rollNumber);
}
