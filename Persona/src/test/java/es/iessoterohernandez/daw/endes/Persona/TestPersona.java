package es.iessoterohernandez.daw.endes.Persona;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestPersona {

	private static Persona p1, p2, p3;

	@BeforeClass
	public static void inicio() {
		p1 = new Persona("Juan", 23, 'H', 70, 1.80);
		p2 = new Persona("Pepe", 17, 'H', 150, 1.85);
		p3 = new Persona("Rosa", 30, 'M', 30, 1.60);
	}
	
	@Test
	public void pruebaIMC() {
		assertEquals(Persona.PESO_IDEAL, p1.calcularIMC());
		assertEquals(Persona.SOBREPESO, p2.calcularIMC());
		assertEquals(Persona.INFRAPESO, p3.calcularIMC());
	}

	@Test
	public void pruebaEsMayorDeEdad() {
		assertTrue(p1.esMayorDeEdad());
		assertFalse(p2.esMayorDeEdad());
	}

}
