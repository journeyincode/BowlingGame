import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BowlingGameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void gutterGameTest() {
        rollMany(20, 0);

        assertEquals(0, game.score());
    }

    private void rollMany(int numRolls, int pinsDown) {
        for (int i = 0; i<numRolls; i++)
            game.roll(pinsDown);
    }

    @Test
    public void rollAllOnesTest() {
        rollMany(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    public void rollOneSpare() {
        rollSpare();

        game.roll(3);
        game.roll(0);

        rollMany(16, 0);

        assertEquals(16, game.score());
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    @Test
    public void rollOneStrikeTest() {
        rollStrike();

        game.roll(3);
        game.roll(4);

        rollMany(17, 0);

        assertEquals(24, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }

    @Test
    public void rollPerfectGameTest() {
        rollMany(12, 10);

        assertEquals(300, game.score());
    }
}
