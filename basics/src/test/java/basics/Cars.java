package basics;

import static org.junit.Assert.*;

import org.junit.Test;

public class Cars {

	@Test
	public void canBuildCar() {
		Car carTest = new Car("Corvette");
		
		carTest.start();
	}
}
