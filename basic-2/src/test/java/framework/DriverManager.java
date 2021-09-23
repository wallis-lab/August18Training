package framework;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
<<<<<<< HEAD
	protected WebDriver driver;
	protected abstract void createDriver();
		
	public WebDriver getDriver() {
		
		if (this.driver == null) {
			throw new RuntimeException("Driver not started");
		}
			return this.driver;
	}
	protected void setDriver(WebDriver targetDriver) {
		driver = targetDriver;
	}

	public void quitDriver() {
=======
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
>>>>>>> refs/remotes/origin/Organize-Selenium-Project
		driver.quit();
		driver = null;
	}
}
