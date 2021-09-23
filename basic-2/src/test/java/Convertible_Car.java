package cars;

public class Convertible_Car extends Car {
	public boolean Convertiblestatus =false; 
	public boolean isStart;

	Convertible_Car(String model, IEngine IEngine) {
		super(model, IEngine);
		IEngine=new SmallEngine();	
	}

	Convertible_Car(String model,boolean Convertiblestatus, IEngine IEngine) {
		super(model, IEngine);
		IEngine=new SmallEngine();
		this.Convertiblestatus=Convertiblestatus;
	}

	public boolean getconvertibleStatus() {
		return this.Convertiblestatus;
	}

	public void start(IEngine IEngine) {
		IEngine.start();
		isStart=true;
	}
}