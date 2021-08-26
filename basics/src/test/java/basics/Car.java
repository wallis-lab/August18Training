package basics;

public class Car {
	private int odometer;
	public String model;
	public IEngine engine=new LargeEngine();
	
	Car(){
		this.odometer=0;
		this.model="";
	}
	
	Car(String model){
		this.model=model;
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
