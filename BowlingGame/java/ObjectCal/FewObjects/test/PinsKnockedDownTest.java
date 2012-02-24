import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PinsKnockedDownTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() throws Exception {
		
		PinsKnockedDown first = new PinsKnockedDown(3);
		PinsKnockedDown second = new PinsKnockedDown(5);
		
		assertEquals(new PinsKnockedDown(8), first.add(second));
	}
	
	@Test
	public void testEquals() throws Exception {
		
		PinsKnockedDown subject = new PinsKnockedDown(1);
		assertFalse(subject.equals(null));

		PinsKnockedDown target = new PinsKnockedDown(1);
		assertTrue(subject.equals(target));
		
		target = new PinsKnockedDown(5);
		assertFalse(subject.equals(target));
	}
	
}
