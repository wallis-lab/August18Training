package test.java.DemoQa.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import test.java.DemoQa.foundation.DemoqaTestBase;
import test.java.DemoQa.pageObjects.DemoqaDynamicPropertiesPage;
import test.java.DemoQa.pageObjects.DemoqaHomePage;
import test.java.DemoQa.pageObjects.DemoqaLinksPage;
import test.java.DemoQa.pageObjects.DemoqaRadioButtonPage;
import test.java.DemoQa.pageObjects.DemoqaTestBoxPage;


public class DemoqaTest extends DemoqaTestBase {
	
	@Test
	public void canClickSubmitAndMatchTextInTextBoxPage() {
		
		new DemoqaHomePage(driver, baseUrl)
		.clickElementsPage()
		.clickTestBoxPage()
		.enterTextInTextBox()
		.clickSubmitButton();

		assertEquals("not the same name", DemoqaTestBoxPage.fullName, DemoqaTestBoxPage.name);	
		assertEquals("not the same email", DemoqaTestBoxPage.Email, DemoqaTestBoxPage.email);	
		assertEquals("not the same current address", DemoqaTestBoxPage.cAddress, DemoqaTestBoxPage.currentAddress);	
		assertEquals("not the same permanent address", DemoqaTestBoxPage.pAddress, DemoqaTestBoxPage.permanentAddress);	
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
		DemoqaLinksPage actualText = new DemoqaLinksPage(driver, baseUrl);
		
		new DemoqaHomePage(driver, baseUrl)
		.clickElementsPage()
		.clickLinksPage()
		.clickHomeHyperLink()
		.clickNewPageJoinNowButton()
		.clickCreatedHyperLink();
	
		assertEquals(ExceptText,actualText.getActualTestWhenClickCreated());		
	}
	
	@Test
	public void canVisibleAfterFiveSecondInDynamicPropertiesPage() {
		DemoqaDynamicPropertiesPage DemoqaDynamicPropertie= new DemoqaDynamicPropertiesPage(driver, baseUrl);
		String ExceptVisbleText = "Visible After 5 Seconds";
		
		driver.get("https://demoqa.com/dynamic-properties");	
		DemoqaDynamicPropertie.waitForTextToAppear(driver);
		String ActualVisbleText = DemoqaDynamicPropertie.getVisibleElement().getText();

		assertTrue(ActualVisbleText.equals(ExceptVisbleText));
	}
}
