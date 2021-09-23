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
		this.driver = targetDriver;
	}

	public void quitDriver() {
		this.driver.quit();
		this.driver = null;
=======
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
		driver.quit();
		driver = null;
>>>>>>> branch 'Design-Patterm-Selenium' of https://github.com/wallis-lab/August18Training
	}
}
