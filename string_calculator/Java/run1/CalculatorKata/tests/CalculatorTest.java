import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setUp() throws Exception {
		this.calculator = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		this.calculator = null;
	}

	@Test
	public void shouldReturn0WhenPassingEmptyString() {
		assertEquals(0, calculator.add(""));
	}

	@Test
	public void shouldReturn0WhenPassingNull() {
		assertEquals(0, calculator.add(null));
	}

	@Test
	public void shouldReturn1WhenPassing1() {
		assertEquals(1, calculator.add("1"));
	}
	
	@Test
	public void shouldReturn2WhenPassing2() {
		assertEquals(2, calculator.add("2"));
	}
	
	@Test
	public void shouldCorrectlySumTwoNumbers(){
		assertEquals(3, calculator.add("1,2"));
	}

}
