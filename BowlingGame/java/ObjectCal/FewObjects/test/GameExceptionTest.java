import org.junit.Before;
import org.junit.Test;

public class GameExceptionTest {

	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullRoll() throws Exception {
		game.roll(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMaxRollsExceeded() throws Exception {
		for (int i = 0; i < 23; i++) {
			game.roll(PinsKnockedDown.NONE);
		}
	}
}
