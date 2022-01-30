package boletinJUnit;

import static org.junit.Assert.*;
import org.junit.Test;

public class OperadorAritmeticoTest {
	
	@Test
	public void suma() {
		int solucion = 10, x = 5, y = 5;	
		int suma = OperadorAritmetico.suma(x, y);
		assertEquals(solucion, suma);
	}

	@Test
	public void divisionConCero() {
		int x = 5, y = 0;
		try {
			OperadorAritmetico.division(x, y);
			fail("Error");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void division() {
		int solucion = 2, x = 10, y = 5, div;
		try {
			div = OperadorAritmetico.division(x, y);
			assertEquals(solucion, div);
		} catch (Exception e) {
			fail();
		}
	}
}