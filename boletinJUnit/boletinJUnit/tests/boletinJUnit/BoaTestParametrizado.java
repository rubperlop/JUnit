package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BoaTestParametrizado {

	@ParameterizedTest(name = "Test IsHealthy")
	@CsvSource({ "Persa1,    	 4,   ensaladilla,   	  false", "Farisea1,    8,   granola bars,   true",
			"Persa2,        4,   mojama,        false", "Farisea2,    8,   queso,      false",
			"Persa3,        4,   granola bars,   true", "Farisea3,    8,   burrito,        false"

	})

	void testIsHealthy1(String name, int length, String food, boolean expectedResult) throws Exception {
		Boa b = new Boa(name, length, food);

		assertEquals(expectedResult, b.isHealthy());
	}

	@ParameterizedTest(name = "Test FitsInCage")
	@CsvSource({ "Persa,    	4,    5,     Pizza,    true", "Farisea,    8,   5,   granola bars,   false"

	})
	void testFitsInCage2(String name, int length, int cageLength, String food, boolean expectedResult)
			throws Exception {
		Boa b = new Boa(name, length, food);

		assertEquals(expectedResult, b.fitsInCage(cageLength));
	}

}