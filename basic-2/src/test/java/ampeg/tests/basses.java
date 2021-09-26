package ampeg.tests;

public class basses {
	private String Make;
	private String Model;

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}
	
	public String toString(){
		return "basses"+Make+"  "+Model;		
	}

}
