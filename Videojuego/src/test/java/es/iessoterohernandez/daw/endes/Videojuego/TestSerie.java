package es.iessoterohernandez.daw.endes.Videojuego;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestSerie {

	static Serie s1;
	static Serie s2;
	static Serie s3;
	static Serie s4;
	
	@BeforeClass
	public static void inicio() {
		
		s1 = new Serie("La casa de papel", 5, "Drama", "Antonio");
		s2 = new Serie("La casa de papel", 5, "Drama", "Antonio");
		s3 = new Serie("Los Serrano", 35, "Comedia", "Daniel Écija");
		s4 = new Serie("Expediente X", 2, "Ciencia Ficción", "Reinaldo");
		
	}
	
	@Test
	public void testEntregar() {
		s1.entregar();
		assertTrue(s1.isEntregado());
	}
	
	@Test
	public void testDevolver() {
		s1.devolver();
		assertFalse(s1.isEntregado());
	}
	
	@Test
	public void testCompareTo() {		
		assertEquals(Serie.IGUAL, s1.compareTo(s2));
		assertEquals(Serie.MAYOR, s1.compareTo(s4));
		assertEquals(Serie.MENOR, s4.compareTo(s3));				
	}
	
	@Test
	public void testToString() {
		assertEquals("Informacion de la Serie: \n" +
                "\tTitulo: "+s1.getTitulo() +"\n" +
                "\tNumero de temporadas: "+s1.getnumeroTemporadas()+"\n" +
                "\tGenero: "+s1.getGenero()+"\n" +
                "\tCreador: "+s1.getcreador(), s1.toString());
	}
	
	@Test
	public void testEquals() {
		assertTrue(s1.equals(s2));
		assertFalse(s1.equals(s3));
		
	}

}
