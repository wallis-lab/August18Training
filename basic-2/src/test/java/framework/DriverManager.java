package framework;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected static WebDriver driver;
	protected abstract void createDriver();
		
	public WebDriver getDriver() {
		
		if (driver == null) {
			createDriver();
		}
			return driver;
	}
	protected void setDriver(WebDriver targetDriver) {
		driver = targetDriver;
	}

	public static void quitDriver() {
		driver.quit();
		driver = null;
	}
}
