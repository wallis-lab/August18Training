import static org.junit.Assert.*;

import org.junit.Test;

public class Cars {

	@Test
	public void canDriveBicycle() {
		Bicycle bicycle= new Bicycle();
		assertTrue("Inconsistent initialization results. ",bicycle.getOdometer()==0);
		assertTrue("Can't ride the bike. ",bicycle.isDriveable()==true);	
	}
	
	@Test
	public void canIncreaOdometer() {
		String model="Corvette";
		IEngine engine = new LargeEngine();
		Car car = new Car(model, engine);
		car.start(engine);
		assertTrue("Engine not start",car.isStart==true);
		assertEquals("Inconsistent initialization results.",0,car.getOdometer());
		car.drive(10);
		assertEquals("No increase in mileage. ",10,car.getOdometer());			
	}
	
	@Test
	public void canBuildCar() {
		int small=4;
		int large=8;
		SmallEngine smallEngine = new SmallEngine();
		LargeEngine largeengine = new LargeEngine();
		assertTrue("small engine is not 4",smallEngine.getCylinderCount()==small);
		assertTrue("large engine is not 8",largeengine.getCylinderCount()==large);
	}
	
	@Test
	public void canStartSmallConvertibleCar() {
		int small=4;
		String model="Convertible";
		SmallEngine smallEngine = new SmallEngine();
		Convertible_Car convertCar = new Convertible_Car(model,smallEngine);
		convertCar.start(smallEngine);
		assertTrue("cylider count not match",smallEngine.getCylinderCount()==small);
		assertTrue("model name not match",convertCar.model==model);
		assertTrue("convertible car start",convertCar.isStart==true);	
	}
	
	@Test
	public void canSwitchConvertible() {
		int[] ConvertibleAdjestment= new int[] {1,2,3,4,5};
		String raise="up";
		String lower="down";
		SmallEngine smallEngine = new SmallEngine();
		Convertible_Car convertCar = new Convertible_Car(raise,ConvertibleAdjestment[2],smallEngine);
		assertTrue("not raise", convertCar.getconvertibleStatus()==raise);
		assertTrue("not level 3", convertCar.getConvertibleAdjestment()==ConvertibleAdjestment[2]);
		Convertible_Car convertCar1 = new Convertible_Car(lower,ConvertibleAdjestment[3],smallEngine);
		assertTrue("not lower", convertCar1.getconvertibleStatus()==lower);
		assertTrue("not level 4", convertCar1.getConvertibleAdjestment()==ConvertibleAdjestment[3]);
	}
}
