package test.java.DemoQa.pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.java.DemoQa.controlExtension.TextboxControlExtension;
import test.java.DemoQa.framework.DemoqaPageObject;

public class DemoqaTestBoxPage extends DemoqaPageObject{
	public static String name = "wenlong";
	public static String email = "123@gmail.com";
	public static String cAddress = "555 11th st";
	public static String pAddress = "666 88th st";
	public static String fullName;
	public static String Email;
	public static String currentAddress;
	public static String permanentAddress;
	
	
	public DemoqaTestBoxPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public DemoqaTestBoxPage enterTextInTextBox(){
		
		TextboxControlExtension Textbox = new TextboxControlExtension(getUserNameAndEmailElement("userName"), driver);
		Textbox.setValue(name);			
		Textbox = new TextboxControlExtension(getUserNameAndEmailElement("userEmail"), driver);
		Textbox.setValue(email);				
		Textbox = new TextboxControlExtension(getCirremtAndPermanentAddressElement("currentAddress"), driver);
		Textbox.setValue(cAddress);			
		Textbox = new TextboxControlExtension(getCirremtAndPermanentAddressElement("permanentAddress"), driver);
		Textbox.setValue(pAddress);		
		clickSubmitButton();

		fullName = new TextboxControlExtension(getTestResultWhenClickSubmitButtonByEachElement("name"), driver).getValue();
		Email = new TextboxControlExtension(getTestResultWhenClickSubmitButtonByEachElement("email"), driver).getValue();
		currentAddress = new TextboxControlExtension(getTestResultWhenClickSubmitButtonByEachElement("currentAddress"), driver).getValue();
		permanentAddress = new TextboxControlExtension(getTestResultWhenClickSubmitButtonByEachElement("permanentAddress"), driver).getValue();	

		return new DemoqaTestBoxPage(this.driver, this.baseUrl);
	}
	
	public DemoqaTestBoxPage clickSubmitButton(){
		WebElement submitButton = getSubmitElement("submit");
	
		submitButton.click();
		
		return new DemoqaTestBoxPage(this.driver, this.baseUrl);
	}
	
	public WebElement getUserNameAndEmailElement(String testElement) {

		return driver.findElement(By.xpath("//form//input[@id='" + testElement + "']"));	
	}
	
	public WebElement getCirremtAndPermanentAddressElement(String addressElement) {

		return driver.findElement(By.xpath("//form//textarea[@id='" + addressElement + "']"));	
	}
	
	public WebElement getSubmitElement(String submitElement) {

		return driver.findElement(By.xpath("//button[@id='" + submitElement + "']"));	
	}
	
	public WebElement getTestResultWhenClickSubmitButton(String outPutElement) {

		return driver.findElement(By.xpath("//div[@id='output']/div[@class='"+ outPutElement +"']"));	

	}

	public WebElement getTestResultWhenClickSubmitButtonByEachElement(String outPutElement) {

		return driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']/p[@id='"+outPutElement+"']"));
	}
}

