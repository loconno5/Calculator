import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testMain() {
		String str = "1+2";
		//str.main();
	}
	
	@Test
	public void testValidateTrue() {
		Calculator calc = new Calculator();
		String eq = "1+2";
		int length = 3;
		assertTrue("Error checking",calc.validate(eq, length));
		String eq2 = "2+3+45";
		int length2 = 6;
		assertTrue(calc.validate(eq2, length2));
		String eq3 = "2-3*45+89076";
		int length3 = 12;
		assertTrue(calc.validate(eq3, length3));
		
	}
	
	@Test
	public void testValidateFalse() {
		Calculator calc = new Calculator();
		String eq = "1++2";
		int length = 4;
		assertFalse(calc.validate(eq, length));
		String eq2 = "bhkhbk";
		int length2 = 6;
		assertFalse(calc.validate(eq2, length2));
		String eq3 = "-23";
		int length3 = 3;
		assertFalse(calc.validate(eq3, length3));
		
	}
	@Test
	public void testCompute() {
		Calculator calc = new Calculator();
		String eq = "1+2 ";
		int length = 3;
		ArrayList numbers = new ArrayList<>();
		ArrayList operators = new ArrayList<>();
		assertEquals("testing compute method", 3, (calc.compute(eq, length,operators,numbers)));
		ArrayList numbers1 = new ArrayList<>();
		ArrayList operators1 = new ArrayList<>();
		String eq1 = "237+456 ";
		int length1 = 7;
		assertEquals("testing compute method", 693,(calc.compute(eq1, length1 ,operators1,numbers1)));
		ArrayList numbers2 = new ArrayList<>();
		ArrayList operators2 = new ArrayList<>();
		String eq2 = "23+45-50 ";
		int length2 = 7;
		assertEquals("testing compute method", 18,(calc.compute(eq2, length2 ,operators2,numbers2)));
		ArrayList numbers3 = new ArrayList<>();
		ArrayList operators3 = new ArrayList<>();
		String eq3 = "2*56-59+20 ";
		int length3 = 10;
		assertEquals("testing compute method", 73,(calc.compute(eq3, length3 ,operators3,numbers3)));
		
		
		
	}

}
