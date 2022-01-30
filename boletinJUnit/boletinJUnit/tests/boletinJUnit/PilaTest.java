package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilaTest {

	public static Pila p;

	@BeforeEach
	void setUp() throws Exception {
		p = new Pila();
	}

	
	@Test
	void testPush() {
		p.push(1);
		assertEquals(true, p.isEmpty());
		p.push(22);
		assertEquals(true, p.isEmpty());
		p.push(11);
		assertEquals(false, p.isEmpty());
	}

	@Test
	void testPop() {
		assertEquals(null, p.pop());
		
		p.push(3);
		p.push(4);
		p.push(5);
		
		assertEquals(5, p.pop());
		assertEquals(4, p.pop());
		assertEquals(3, p.pop());
	}

	@Test
	void testIsEmpty() {
		assertEquals(true, p.isEmpty());

		p.push(15);
		assertEquals(false, p.isEmpty());
	}

	@Test
	void testTop() {
		assertEquals(null, p.top());

		p.push(7);
		p.push(8);
		p.push(9);

		assertEquals(9, p.top());
	}

}
