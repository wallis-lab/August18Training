package Car;

public class SmallEngine implements IEngine{
	
	public int cylinderCount=4;
	
	public void start() {
		System.out.println("Engine Started");
	}	
	
	public int getCylinderCount() {
		return this.cylinderCount;
	}
}
