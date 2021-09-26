package test.java.DemoQa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.DemoQa.framework1.DemoqaPageObject1;

public class DemoqaRadioButtonPage extends DemoqaPageObject1{
	public static String clickImpressiveOutPutText;
	public static String clickYesOutputText;
	public DemoqaRadioButtonPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public DemoqaRadioButtonPage clickYesButton() {
		WebElement RadioButtonElement = getRadioButtonElement("yesRadio");
		RadioButtonElement.click();
		clickYesOutputText=getTextWhenClickAnyButton();
		return new DemoqaRadioButtonPage(this.driver, this.baseUrl);
	}


	public DemoqaRadioButtonPage clickImpressiveButton() {
		
		WebElement RadioButtonElement = getRadioButtonElement("impressiveRadio");
		RadioButtonElement.click();
		clickImpressiveOutPutText=getTextWhenClickAnyButton();
		return new DemoqaRadioButtonPage(this.driver, this.baseUrl);
	}
	
	public String getTextWhenClickAnyButton() {
		WebElement RadioButtonElement = getAfterClickButtonTextElement("text-success");
		RadioButtonElement.click();
		return RadioButtonElement.getText();
	}
	
	public WebElement getRadioButtonElement(String RadioButtonElement) {

		return driver.findElement(By.xpath("//label[@for='" + RadioButtonElement + "']"));	
	}
	
	public WebElement getAfterClickButtonTextElement(String testElement) {

		return driver.findElement(By.xpath("//p/span[@class='"+ testElement +"']"));	
	}
	
}
