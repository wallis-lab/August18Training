package test.java.DemoQa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.java.DemoQa.controlExtension.radioButtonControlExtension;
import test.java.DemoQa.framework.DemoqaPageObject;

public class DemoqaRadioButtonPage extends DemoqaPageObject{
	
	public static String clickImpressiveOutPutText;
	public static String clickYesOutputText;
	public DemoqaRadioButtonPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public DemoqaRadioButtonPage clickYesButton() {
		
		radioButtonControlExtension radioButton = new radioButtonControlExtension(driver.findElement(By.xpath("//label[@for='yesRadio']")),driver);
		radioButton.select("Yes");
	
		clickYesOutputText=radioButton.getSelect();
		
		return new DemoqaRadioButtonPage(this.driver, this.baseUrl);
	}

	public DemoqaRadioButtonPage clickImpressiveButton() {
		
		radioButtonControlExtension radioButton = new radioButtonControlExtension(driver.findElement(By.xpath("//label[@for='impressiveRadio']")),driver);
		radioButton.select("Impressive");
	
		clickImpressiveOutPutText=radioButton.getSelect();
		
		return new DemoqaRadioButtonPage(this.driver, this.baseUrl);
	}
	/*public void checkElement() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='mt-3']")));
	}*/

	
	/*public String getTextWhenClickAnyButton() {
		
		WebElement RadioButtonElement = getAfterClickButtonTextElement("text-success");
		
		RadioButtonElement.click();
		
		return RadioButtonElement.getText();
	}*/
	
	/*public WebElement getRadioButtonElement(String RadioButtonElement) {

		return driver.findElement(By.xpath("//label[@for='" + RadioButtonElement + "']"));	
	}*/
	
	/*public WebElement getAfterClickButtonTextElement(String testElement) {

		return driver.findElement(By.xpath("//p/span[@class='"+ testElement +"']"));	
	}*/
}

