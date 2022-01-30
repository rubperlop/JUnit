package es.iessoterohernandez.daw.endes.ShoppingCart;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ShoppingCartTest {

	static Product p;
	static Product p2;

	@BeforeClass
	public static void inicio() {

		p = new Product("Reloj", 30);
		p2 = new Product("Collar", 130);

	}
	
	@Test
	public void testCreaCarro() {

		ShoppingCart s = new ShoppingCart();
		assertEquals(0, s.getItemCount());

	}

	@Test
	public void estaVacio() {

		ShoppingCart s = new ShoppingCart();

		s.empty();
		assertEquals(0, s.getItemCount());

	}

	@Test
	public void aniadeProducto() {

		ShoppingCart s = new ShoppingCart();

		assertEquals(0, s.getItemCount());
		s.addItem(p);

		assertEquals(1, s.getItemCount());

	}
	
	@Test
	public void productoBalance() {

		ShoppingCart s = new ShoppingCart();
		s.addItem(p);
		assertEquals(30, s.getBalance());

		s.addItem(p2);
		assertEquals(160, s.getBalance());

	}
	
	@Test
	public void eliminaProducto() throws ProductNotFoundException {

		ShoppingCart s = new ShoppingCart();
		s.addItem(p);
		assertEquals(1, s.getItemCount());

		s.removeItem(p);
		assertEquals(0, s.getItemCount());

	}
	
	@Test
	public void exception() {

		ShoppingCart s = new ShoppingCart();
		
		try {
			s.removeItem(p2);
		} catch (ProductNotFoundException e) {

			fail("Este producto no está en el carrito");

		}
	}
}
