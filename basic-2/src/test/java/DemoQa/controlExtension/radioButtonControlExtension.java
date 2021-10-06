package test.java.DemoQa.controlExtension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.java.DemoQa.pageObjects.DemoqaRadioButtonPage;

public class radioButtonControlExtension {
	private WebElement mappedElement;
	private WebDriver driver; 
	
	public radioButtonControlExtension(WebElement mappedElement, WebDriver driver){
		this.mappedElement=mappedElement;
		this.driver=driver;
	}
	public void select(String label) {
	
		if (label=="Yes") {
			mappedElement.click();
			checkAftherClick();
			
			DemoqaRadioButtonPage.clickYesOutputText= getSelect();
		}
		if (label == "Impressive") {
			
			mappedElement.click();
			checkAftherClick();
			DemoqaRadioButtonPage.clickImpressiveOutPutText= getSelect();
		}
	}
	public String getSelect() {
		String test = mappedElement.findElement(By.xpath("//p/span[@class='text-success']")).getText();	
		return test;
	}
	public void checkAftherClick() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='mt-3']")));
	}
	
}
