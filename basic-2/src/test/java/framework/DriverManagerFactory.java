package framework;

public class DriverManagerFactory {
	public static DriverManager driverManager;
	
	public static DriverManager getManager(String driverType) {
		
		if(driverType.equals("Chrome")){
			System.setProperty(ChromeDriverManager.WEB_DRIVER_SYSTEM_PROPERTY_CHROME, ChromeDriverManager.chromeDriverPath);
			
			driverManager =	new ChromeDriverManager();
	
		}else if(driverType.equals("Edge")){
			System.setProperty(EdgeDriverManager.WEB_DRIVER_SYSTEM_PROPERTY_EDGE, EdgeDriverManager.edgeDriverPath);
			
			driverManager=new EdgeDriverManager();
			
		}
		return driverManager;
	}
}

