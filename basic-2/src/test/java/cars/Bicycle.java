package cars;

public class Bicycle extends Vehicle{
	private int odometer=0;

	public int getOdometer() {
		return this.odometer;
	}
	
	public void drive(int distance) {
		this.odometer+=distance;
	}
	
	boolean isDriveable() {
		return true;
	}
}
