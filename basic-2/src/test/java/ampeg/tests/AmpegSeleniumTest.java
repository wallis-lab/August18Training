package ampeg.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import ampeg.foundation.AmpegTestBase;
import ampeg.pageObjects.AmpegHomePage;
import ampeg.pageObjects.SVT410HLFDetailPage;


public class AmpegSeleniumTest extends AmpegTestBase {
	
	@Test
	public void canClickHomeBreadcrumbLink() {
		
		String expectUrl = "https://ampeg.com/index.html";
		
		new AmpegHomePage(driver, baseUrl)
		.clickProductPage()
		.clickSvtProPage()
		.clickSvtProduct()
		.clickHomepage();
	
		assertTrue("Not navigate to the expected URL"+ expectUrl, this.driver.getCurrentUrl().equals(expectUrl));	
	}
	
	@Test
	public void checkProductWeightInSvt410Page(){
		
		String expetdText="Handling Weight: 85 Pounds";
		
		new AmpegHomePage(driver, baseUrl)
		.clickProductPage()
		.clickClassicSeriesPage()
		.clickSVT410HLFDetailPage();
		
		String Svt410HandlingText=new SVT410HLFDetailPage(driver, baseUrl).returnTheHandlingweightValue();
		
		assertEquals(expetdText, Svt410HandlingText);
	}
}