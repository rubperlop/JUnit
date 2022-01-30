package es.iessoterohernandez.daw.endes.dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditoTest {

	Cuenta c;
	Credito t;
	Movimiento m;

	@BeforeEach
	public void setUp() throws Exception {
		c = new Cuenta("123456789", "Juan Adana");

		String caducidad = "01/02/2023";
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date duracion = formato.parse(caducidad);
		Date fechaCaducidad = new Date(duracion.getTime());

		t = new Credito("987654321", "Juan Adana", fechaCaducidad, 1500.0);
		t.setCuenta(c);
	}

	@Test
	public void testRetirar() {
		try {
			t.ingresar(1000.0);
			t.retirar(-100);
		} catch (Exception e) {
			fail("Error al retirar");
		}
		assertEquals(1003, t.getSaldo());
	}

	@Test
	public void testIngresar() {
		try {
			t.ingresar(100);
			assertEquals(100, t.getSaldo());
			t.ingresar(100);
		} catch (Exception e) {
			fail("Error al ingresar");
		}
		assertEquals(200, t.getSaldo());
	}

	@Test
	public void testPagoEnEstablecimiento() {
		try {
			t.ingresar(300);
			t.pagoEnEstablecimiento("Carrefour", -100);
		} catch (Exception e) {
			fail("Error al pagar");
		}
		assertEquals(200, t.getSaldo());
	}

	@Test
	public void testGetSaldo() {
		try {
			t.ingresar(100);
		} catch (Exception e) {
			fail("Error");
		}
		assertEquals(100.0, t.getSaldo());
	}

	@Test
	public void testGetCreditoDisponible() {
		try {
			t.ingresar(100);
		} catch (Exception e) {
			fail("Error");
		}
		assertEquals(1400, t.getCreditoDisponible());
	}
	
	/* La tarjeta tiene sus propios movimientos y no encuentro ninguna manera de añadir un movimiento que tenga una fecha
	 * y el liquidar va en base a las fechas de los movimientos de la tarjeta
	@Test
	public void testLiquidar() {
		try {
			String caducidad = "01/02/2023";
			DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date duracion = formato.parse(caducidad);
			Date fechaCaducidad = new Date(duracion.getTime());

			Credito cr = new Credito("987654321", "Juan Adana", fechaCaducidad, 1500.0);
			Cuenta cu = new Cuenta("123455623423", "Reinaldo Arenas");
			Movimiento m = new Movimiento();
			m.setImporte(100);
						
			m.setFecha(new Date(formato.parse("01/11/2021").getTime()));
			cu.addMovimiento(m);
			cr.setCuenta(cu);
			cr.liquidar(11, 2021);
			assertEquals(200, cr.getSaldo());

		} catch (Exception e) {
			fail("Error");
		}
		
	}
	*/

}
