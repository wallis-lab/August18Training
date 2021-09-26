package test.java.DemoQa.framework1;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager1 extends DriverManager1{
		private final String WEB_DRIVER_SYSTEM_PROPERTY_CHROME = "webdriver.chrome.driver";
		private final String chromeDriverPath = "resources\\chromedriver.exe";

		ChromeDriverManager1(){
			System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY_CHROME, chromeDriverPath);
		}

		public void createDriver() {
			setDriver(new ChromeDriver());
		}
	}