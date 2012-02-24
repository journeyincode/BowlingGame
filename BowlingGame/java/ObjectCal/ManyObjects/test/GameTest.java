import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void gutterGameTest() {
        rollMany(20, 0);
        assertEquals(new Score(0), game.score());
    }

    @Test
    public void rollAllOnesTest() {
        rollMany(20, 1);
        assertEquals(new Score(20), game.score());
    }

    @Test
    public void rollSpareTest() {
        roll(5);       //spare
        roll(5);

        roll(3);
        rollMany(17, 0);

        assertEquals(new Score(16), game.score());
    }

    @Test
    public void rollThirteenTest() {
        roll(0);
        roll(5);
        roll(5);
        roll(3);

        rollMany(16, 0);

        assertEquals(new Score(13), game.score());
    }

    @Test
    public void rollStrike() {
        roll(10);
        roll(3);
        roll(4);
        rollMany(16, 0);
        assertEquals(new Score(24), game.score());

    }

    @Test
    public void perfectGameTest() {
        rollMany(12,10);
        assertEquals(new Score(300), game.score());
    }

    private void roll(int pinsDown) {
        game.roll(new Pins(pinsDown));
    }

    private void rollMany(int numRolls, int pinsDown) {
        for (int i = 0; i < numRolls; i++) {
            game.roll(new Pins(pinsDown));
        }
    }
}
