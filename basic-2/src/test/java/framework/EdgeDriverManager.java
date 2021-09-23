package framework;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager{
<<<<<<< HEAD

	private final String WEB_DRIVER_SYSTEM_PROPERTY_EDGE = "webdriver.edge.driver";
	private final String edgeDriverPath = "resources\\msedgedriver.exe";
	
	EdgeDriverManager(){
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY_EDGE, edgeDriverPath);
	}
	
=======
	private final String WEB_DRIVER_SYSTEM_PROPERTY_EDGE = "webdriver.edge.driver";
	private final String edgeDriverPath = "resources\\msedgedriver.exe";
	
	EdgeDriverManager(){
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY_EDGE, edgeDriverPath);
	}
>>>>>>> branch 'Design-Patterm-Selenium' of https://github.com/wallis-lab/August18Training
	public void createDriver() {
		setDriver(new EdgeDriver());
	}
}

