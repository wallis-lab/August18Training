package framework;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager{
	public static final String WEB_DRIVER_SYSTEM_PROPERTY_EDGE = "webdriver.edge.driver";
	public static final String edgeDriverPath = "resources\\msedgedriver.exe";
	
	EdgeDriverManager(){
		super();
		System.setProperty(EdgeDriverManager.WEB_DRIVER_SYSTEM_PROPERTY_EDGE, EdgeDriverManager.edgeDriverPath);
	}
	public void createDriver() {
		setDriver(new EdgeDriver());
	}
}

