package test.java.DemoQa.tests;
import static org.junit.Assert.assertArrayEquals;
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
	String expectTest[] = {"Name:wenlong", "Email:123@gmail.com","Current Address :555 11th st","Permananet Address :666 88th st"};
	
		new DemoqaHomePage(driver, baseUrl)
		.clickElementsPage()
		.clickTestBoxPage()
		.enterTextInTextBox()
		.clickSubmitButton();
		
		String[] actualTest = new DemoqaTestBoxPage(driver, baseUrl).getTextWhenClickSubmitButton();
		
		assertArrayEquals("asd", expectTest, actualTest);	
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
		DemoqaDynamicPropertiesPage DemoqaDynamicPropertie= new DemoqaDynamicPropertiesPage(driver, baseUrl);
		String ExceptVisbleText = "Visible After 5 Seconds";
		
		driver.get("https://demoqa.com/dynamic-properties");	
		DemoqaDynamicPropertie.waitForTextToAppear(driver);
		String ActualVisbleText = DemoqaDynamicPropertie.getVisibleElement().getText();

		assertTrue(ActualVisbleText.equals(ExceptVisbleText));
	}
}
