package es.iessoterohernandez.daw.endes.Videojuego;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestVideojuego {

	static Videojuego v1;
	static Videojuego v2;
	static Videojuego v3;
	static Videojuego v4;
	
	@BeforeClass
	public static void inicio() {
		
		v1 = new Videojuego("Halo", 30, "FPS", "Bungie");
		v2 = new Videojuego("Halo", 30, "FPS", "Bungie");
		v3 = new Videojuego("Resident Evil", 35, "Survival Horror", "Capcom");
		v4 = new Videojuego ("Minecraft", 20, "Mundo abierto", "Microsoft");
		
	}
	
	@Test
	public void testEntregar() {
		v1.entregar();
		assertTrue(v1.isEntregado());
	}
	
	@Test
	public void testDevolver() {
		v1.devolver();
		assertFalse(v1.isEntregado());
	}
	
	@Test
	public void testCompareTo() {		
		assertEquals(Serie.IGUAL, v1.compareTo(v2));
		assertEquals(Serie.MAYOR, v1.compareTo(v4));
		assertEquals(Serie.MENOR, v1.compareTo(v3));				
	}
	
	@Test
	public void testToString() {
		assertEquals("Informacion del videojuego: \n" +
	               "\tTitulo: "+v1.getTitulo()+"\n" +
	               "\tHoras estimadas: "+v1.getHorasEstimadas()+"\n" +
	               "\tGenero: "+v1.getGenero()+"\n" +
	               "\tcompañia: "+v1.getcompañia(), v1.toString());
	}
	
	
	@Test
	public void testEquals() {
		assertTrue(v1.equals(v2));
		assertFalse(v1.equals(v3));
		
	}

}
