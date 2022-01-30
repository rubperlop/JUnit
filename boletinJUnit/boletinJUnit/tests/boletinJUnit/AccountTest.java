package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	Account a;
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();

	@BeforeEach
	public void setUp() throws Exception {
		a = new Account("Juan", 15001600, 1.5f);
	}

	@Test
	public void testDeposit() {
		assertEquals(false, a.deposit(-1f));
		assertEquals(true, a.deposit(1f));

	}

	
	@Test
	public void testWithdraw() {
		assertEquals(false, a.withdraw(-1f, -2f));
		assertEquals(true, a.withdraw(0.4f, 1f));
	}

	@Test
	public void testAddInterest() {
		a.addInterest();
		assertEquals(1.5f + (1.5f * 0.045f), a.getBalance());
	}

	@Test
	public void testGetBalance() {
		assertEquals(1.5f, a.getBalance());
	}

	@Test
	public void testGetAccountNumber() {
		assertEquals(15001600, a.getAccountNumber());
	}

	@Test
	public void testToString() {
		assertEquals(15001600 + "\t" + "Juan" + "\t" + fmt.format(1.5f), a.toString());
	}
	
	//Se pretende que el resultado no sea preciso al usar floats, pero no entiendo por qué sí lo hace correctamente
	@Test
	public void testDefectoSutil() {
		a.withdraw(0.05f, 0.01f);
		assertEquals(1.44f, a.getBalance());
	}

}