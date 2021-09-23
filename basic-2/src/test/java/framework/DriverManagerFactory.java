package framework;

public class DriverManagerFactory {

	public static DriverManager getManager(String driverType) {
		
		if(driverType.equals("Chrome")){
			return new ChromeDriverManager();
	
		}else if(driverType.equals("Edge")){
			return new EdgeDriverManager();	
		}
		throw new IllegalArgumentException("This driver type is not supported: " + driverType);
	}

}