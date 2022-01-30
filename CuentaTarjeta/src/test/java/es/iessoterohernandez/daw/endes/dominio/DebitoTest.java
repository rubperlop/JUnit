package es.iessoterohernandez.daw.endes.dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DebitoTest {

	Debito d;
	Cuenta c;

	@BeforeEach
	public void setUp() throws Exception {
		c = new Cuenta("123456789", "Juan Adana");

		String caducidad = "01/02/2023";
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date duracion = formato.parse(caducidad);
		Date fechaCaducidad = new Date(duracion.getTime());
		d = new Debito("987654321", "Juan Adana", fechaCaducidad);
		d.setCuenta(c);
	}

	@Test
	public void testRetirar() {
		try {
			d.ingresar(100);
			d.retirar(50.0);
			assertEquals(50, d.getSaldo());
		} catch (Exception e) {
			fail("Error al retirar");
		}
	}

	@Test
	public void testIngresar() {
		try {
			d.ingresar(100.0);
			assertEquals(100, d.getSaldo());
		} catch (Exception e) {
			fail("Error al ingresar");
		}
	}

	@Test
	public void testPagoEnEstablecimiento() {
		try {
			d.ingresar(300.0);
			d.pagoEnEstablecimiento("Carrefour", 5);
			assertEquals(295, d.getSaldo());
		} catch (Exception e) {
			fail("Error al pagar");
		}
	}

	@Test
	public void testGetSaldo() {
		try {
			d.ingresar(200.0);
			assertEquals(200.0, d.getSaldo());
		} catch (Exception e) {
			fail("Error al ingresar");
		}

	}

}