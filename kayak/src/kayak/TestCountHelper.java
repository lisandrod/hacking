package kayak;

import org.junit.Before;
import org.junit.Test;

public class TestCountHelper {
	
	private CountHelper counter;

	@Before
	public void staticSetup(){
		counter = new CountHelper();
		System.out.println("------------------");
	}
	
	@Test
	public void testCountUp(){
		counter.countUp(0, 5);
	}
	
	@Test
	public void testCountUpAndDown(){
		counter.countUpAndDown(0, 5);
	}
}
