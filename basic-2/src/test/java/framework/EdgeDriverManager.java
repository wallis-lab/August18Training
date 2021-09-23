package framework;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager{
<<<<<<< HEAD
	private final String WEB_DRIVER_SYSTEM_PROPERTY_EDGE = "webdriver.edge.driver";
	private final String edgeDriverPath = "resources\\msedgedriver.exe";
	
	EdgeDriverManager(){
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY_EDGE, edgeDriverPath);
=======
	public static final String WEB_DRIVER_SYSTEM_PROPERTY_EDGE = "webdriver.edge.driver";
	public static final String edgeDriverPath = "resources\\msedgedriver.exe";
	
	EdgeDriverManager(){
		super();
		System.setProperty(EdgeDriverManager.WEB_DRIVER_SYSTEM_PROPERTY_EDGE, EdgeDriverManager.edgeDriverPath);
>>>>>>> refs/remotes/origin/Organize-Selenium-Project
	}
	public void createDriver() {
		setDriver(new EdgeDriver());
	}
}

