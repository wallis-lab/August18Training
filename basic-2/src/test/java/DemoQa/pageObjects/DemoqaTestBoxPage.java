package test.java.DemoQa.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.DemoQa.framework.DemoqaPageObject;

public class DemoqaTestBoxPage extends DemoqaPageObject{
	public static String name = "wenlong";
	public static String email = "123@gmail.com";
	public static String cAddress = "555 11th st";
	public static String pAddress = "666 88th st";
	
	public DemoqaTestBoxPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public DemoqaTestBoxPage enterTextInTextBox(){
			
		WebElement userName = getUserNameAndEmailElement("userName");
		WebElement userEmail = getUserNameAndEmailElement("userEmail");
		WebElement currentAddress = getCirremtAndPermanentAddressElement("currentAddress");
		WebElement PermanentAddress = getCirremtAndPermanentAddressElement("permanentAddress");
		
		userName.sendKeys(name);
		userEmail.sendKeys(email);
		currentAddress.sendKeys(cAddress);
		PermanentAddress.sendKeys(pAddress);

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
	public String[] getTextWhenClickSubmitButton() {
		
		WebElement inputText = getTestResultWhenClickSubmitButton("border col-md-12 col-sm-12");
		
		String[] test = inputText.getText().split("\n");
		
		return test;	
	}
	
	public WebElement getTestResultWhenClickSubmitButtonByEachElement(String outPutElement) {

		return driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']/p[@id='"+outPutElement+"']"));
	}
}

