public class Game {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pinsDown) {
        rolls[currentRoll++] = pinsDown;
     }

    public int score() {
        int score = 0;
        int i = 0;
        for (int frame = 0; frame<10; frame++ ) {
            if (isStrike(i)) {
                score += 10 + strikeBonus(i);
                i++;
            } else if (isSpare(i)) {
                score += 10 + spareBonus(i);
                i += 2;
            } else {
                score += sumFrame(i);
                i +=2;
            }
        }

        return score;
    }

    private int strikeBonus(int i) {
        return rolls[i + 1] + rolls[i + 2];
    }

    private int spareBonus(int i) {
        return rolls[i+2];
    }

    private int sumFrame(int i) {
        return rolls[i] + rolls[i+1];
    }

    private boolean isSpare(int i) {
        return rolls[i] + rolls[i+1] == 10;
    }

    private boolean isStrike(int i) {
        return rolls[i] == 10;
    }
}
