package test.java.DemoQa.framework1;

public class DriverManagerFactory1 {

	public static DriverManager1 getManager(String driverType) {
		
		if(driverType.equals("Chrome")){
			return new ChromeDriverManager1();
	
		}/*else if(driverType.equals("Edge")){
			return new EdgeDriverManager();	
		}*/
		throw new IllegalArgumentException("This driver type is not supported: " + driverType);
	}
}