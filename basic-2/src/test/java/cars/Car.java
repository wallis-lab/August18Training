package cars;

public class Car extends Vehicle {
	private int odometer=0;
	public String model;
	public boolean isStart;
	
	Car(String model, IEngine Iengine){
		 this.model=model;
		 Iengine=new LargeEngine();
		 isStart=true;
	}
	
	public int getOdometer() {
		return this.odometer;
	}
	
	public void drive(int distance) {
		this.odometer+=distance;
	}
	
	public boolean getIsStart() {
		return this.isStart;
	}
}
