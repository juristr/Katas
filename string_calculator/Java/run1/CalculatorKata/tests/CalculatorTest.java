import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

    @Test
    public void shouldReturn0WhenPassingEmptyString() {
        //arrange
        Calculator calc = new Calculator();

        //act
        int result = calc.add("");

        //assert
        assertEquals(0, result);        
    }
    
    @Test
    public void shouldReturn0WhenPassingNull()  {
        //arrange
        Calculator calc = new Calculator();

        //act
        int result = calc.add(null);

        //assert
        assertEquals(0, result);
    }
	
}
