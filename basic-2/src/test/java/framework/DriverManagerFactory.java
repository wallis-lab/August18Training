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
	
	public static DriverManager getManager(String driverType) {
		
		if(driverType.equals("Chrome")){
			return new ChromeDriverManager();
	
		}else if(driverType.equals("Edge")){
			return new EdgeDriverManager();	
		}
		throw new IllegalArgumentException("This driver type is not supported: " + driverType);
	}
}
>>>>>>> branch 'Design-Patterm-Selenium' of https://github.com/wallis-lab/August18Training
