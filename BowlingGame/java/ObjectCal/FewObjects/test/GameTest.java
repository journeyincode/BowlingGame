import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void testRoll() throws Exception {

		game.roll(PinsKnockedDown.NONE);
		assertEquals(PinsKnockedDown.NONE, game.score());

	}

	@Test
	public void testMultipleRolls() throws Exception {

		game.roll(new PinsKnockedDown(5));
		assertEquals(new PinsKnockedDown(5), game.score());

		game.roll(new PinsKnockedDown(5));
		assertEquals(new PinsKnockedDown(10), game.score()); //spare, bonus will be seen on next roll

		game.roll(new PinsKnockedDown(5));
		assertEquals(new PinsKnockedDown(20), game.score());

	}

	@Test
	public void testEmptyGame() throws Exception {

		assertEquals(PinsKnockedDown.NONE, game.score());
	}

	@Test
	public void testGutterGame() throws Exception {

		for (int i = 0; i < 20; i++) {
			game.roll(PinsKnockedDown.NONE);
		}
		assertEquals(PinsKnockedDown.NONE, game.score());
	}

	@Test
	public void testRollAllOnes() throws Exception {

		for (int i = 0; i < 20; i++) {
			game.roll(new PinsKnockedDown(1));
		}
		assertEquals(new PinsKnockedDown(20), game.score());
	}

	@Test
	public void rollSpare() throws Exception {

		game.roll(new PinsKnockedDown(5));
		game.roll(new PinsKnockedDown(5));
		game.roll(new PinsKnockedDown(3));

		assertEquals(new PinsKnockedDown(16), game.score());
	}

	@Test
	public void testRollThirteen() throws Exception {

		game.roll(PinsKnockedDown.NONE);
		game.roll(new PinsKnockedDown(5));
		game.roll(new PinsKnockedDown(5));
		game.roll(new PinsKnockedDown(3));

		assertEquals(new PinsKnockedDown(13), game.score());
	}

	@Test
	public void testPerfectGame() throws Exception {

		for (int i = 0; i < 12; i++) {
			game.roll(PinsKnockedDown.STRIKE);
		}
		assertEquals(new PinsKnockedDown(300), game.score());
	}

	@Test(expected=IllegalArgumentException.class)
	public void test13Strikes() throws Exception {

		for (int i = 0; i < 13; i++) {
			game.roll(PinsKnockedDown.STRIKE);
		}
	}

	@Test
	public void rollAllSpares() throws Exception {

		for (int i = 0; i < 21; i++) {
			game.roll(new PinsKnockedDown(5));
		}
		assertEquals(new PinsKnockedDown(150), game.score());

	}

}
