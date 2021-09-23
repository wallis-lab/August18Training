package framework;

public class DriverManagerFactory {
<<<<<<< HEAD
	
	public static DriverManager getManager(String driverType) {
		
		if(driverType.equals("Chrome")){
			return new ChromeDriverManager();
	
		}else if(driverType.equals("Edge")){
			return new EdgeDriverManager();	
		}
		throw new IllegalArgumentException("This driver type is not supported: " + driverType);
	}
}
=======
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

>>>>>>> refs/remotes/origin/Organize-Selenium-Project
