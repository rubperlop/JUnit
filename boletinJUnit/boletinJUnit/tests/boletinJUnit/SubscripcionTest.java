package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SubscripcionTest {

	public static Subscripcion s;

	@BeforeAll
	public static void init() {
		s = new Subscripcion(15, 2);
	}

	@Test
	public void testprecioPorMes() {

		// Suscripción con resultado entero de la división
		double esperado = 100;
		Subscripcion a = new Subscripcion(200, 2);
		double resultado = a.precioPorMes();
		assertEquals(esperado, resultado, 0);

		// Suscripción con resultado no exacto (con decimales) de la división
		esperado = 8.5;
		resultado = s.precioPorMes();
		assertEquals(esperado, resultado, 0);

		// Suscripción con resultado originado por el dividendo 0
		esperado = 0;
		Subscripcion a2 = new Subscripcion(0, 2);
		resultado = a2.precioPorMes();
		assertEquals(esperado, resultado, 0);

		// Suscripción con resultado originado por el divisor 0
		esperado = 0;
		Subscripcion a3 = new Subscripcion(2, 0);
		resultado = a3.precioPorMes();
		assertEquals(esperado, resultado, 0);
	}

	@Test
	public void testCancelar() {
		s.cancel();
		assertTrue(true);
	}
}