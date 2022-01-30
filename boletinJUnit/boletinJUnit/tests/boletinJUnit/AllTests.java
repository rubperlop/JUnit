package boletinJUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OperadorAritmeticoTest.class, BoaTestParametrizado.class, PilaTest.class, SubscripcionTest.class })
public class AllTests {

}
