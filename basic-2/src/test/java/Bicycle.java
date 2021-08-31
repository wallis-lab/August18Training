import java.lang.invoke.ConstantBootstraps;

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
	
	public void start() {
		System.out.println("Start riding");
	}
}
