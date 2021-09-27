package test.java.DemoQa.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import test.java.DemoQa.foundation.DemoqaTestBase;
import test.java.DemoQa.pageObjects.DemoqaDynamicPropertiesPage;
import test.java.DemoQa.pageObjects.DemoqaHomePage;
import test.java.DemoQa.pageObjects.DemoqaLinksPage;
import test.java.DemoQa.pageObjects.DemoqaRadioButtonPage;


public class DemoqaTest1 extends DemoqaTestBase {
	
	
	@Test
	public void canClickSubmitAndMatchTextInTextBoxPage() {
	//String expectUrl = "https://ampeg.com/index.html";

		new DemoqaHomePage(driver, baseUrl)
		.clickElementsPage()
		.clickTestBoxPage()
		.enterTextInTextBox()
		.clickSubmitButton();
		
	}

	@Test
	public void canClickRadioButoonAndMatchTextInRadioPage() {
		String clickYes = "Yes";
		String clickImpressive = "Impressive";
		
		new DemoqaHomePage(driver, baseUrl)
		.clickElementsPage()
		.clickRadioButtonPage()
		.clickYesButton()
		.clickImpressiveButton();
		
		assertEquals(DemoqaRadioButtonPage.clickYesOutputText,clickYes);
		assertEquals(DemoqaRadioButtonPage.clickImpressiveOutPutText,clickImpressive);
	}
	@Test
	public void canClickHomeLink() throws InterruptedException {
		String ExceptText = "Link has responded with staus 201 and status text Created";
		new DemoqaHomePage(driver, baseUrl)
		.clickElementsPage()
		.clickLinksPage()
		.clickHomeHyperLink()
		.clickNewPageJoinNowButton()
		.clickCreatedHyperLink();
		
		DemoqaLinksPage actualText = new DemoqaLinksPage(driver, baseUrl);
		
		assertEquals(ExceptText,actualText.getActualTestWhenClickCreated());
		
	}
	@Test
	public void canVisibleAfterFiveSecondInDynamicPropertiesPage() {
		String ExceptVisbleText = "Visible After 5 Seconds";
		driver.get("https://demoqa.com/dynamic-properties");
		
		DemoqaDynamicPropertiesPage.waitForTextToAppear(driver);
		
		/*DemoqaDynamicPropertiesPage DemoqaDynamicPropertie= new DemoqaDynamicPropertiesPage(driver, baseUrl);
		
		String ActualVisbleText = DemoqaDynamicPropertie.getVisibleElement().getText();*/
		
		assertTrue(DemoqaDynamicPropertiesPage.waitForTextToAppear(driver)=true);
	
	}

}