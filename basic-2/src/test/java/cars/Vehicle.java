package cars;

public abstract class Vehicle {
	
	public String model;
	
	abstract int getOdometer();
	abstract void drive(int distance);
}
