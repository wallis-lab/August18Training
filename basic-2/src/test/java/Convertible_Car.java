import java.util.jar.Attributes.Name;

public class Convertible_Car extends Car {
	public String convertibleStatus="";
	public int ConvertibleAdjestment=0; 
	public boolean isStart;
	
	Convertible_Car(String convertibleStatus, int ConvertibleAdjestment, IEngine IEngine){
		super(IEngine);
		this.convertibleStatus=convertibleStatus;
		this.ConvertibleAdjestment=ConvertibleAdjestment;
	}
	
	Convertible_Car(String model, IEngine IEngine) {
		super(model, IEngine);
		IEngine=new SmallEngine();	
	}
	
	public int getConvertibleAdjestment() {
			return this.ConvertibleAdjestment;
	}
	
	public String getconvertibleStatus() {
		return this.convertibleStatus;
	}
	
	public void start(IEngine IEngine) {
		IEngine.start();
		isStart=true;
	}
}
