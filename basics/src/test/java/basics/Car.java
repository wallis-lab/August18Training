package basics;

public class Car {
	private int odometer;
	public String model;
	public IEngine engine;
	
	Car(String model){
		this.model=model;
		engine=new LargeEngine();
	}
	
	int getOdometer(int odo) {
		return this.odometer=odo;
	}
	
	public void drive(int distance) {
		this.odometer+=distance;
	}
	
	public void start() {
		this.engine.start();
	}
}
