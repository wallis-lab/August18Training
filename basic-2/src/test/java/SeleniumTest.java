import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SeleniumTest extends TestBase {
	
	@Test
	public void canDisplayHomepage() {
		
		String expetdUrl= this.baseUrl+"/index.html";
		
		assertEquals(expetdUrl, driver.getCurrentUrl());
	}
	
	@Test
	public void canDisplayProductPage() {
		
		String expectUrl = this.baseUrl+"/products/";
		
		new SeleniumAmpegHomePage(driver, baseUrl).clickProductPage();
		
		assertTrue("Not navigate to the expected URL" + expectUrl , this.driver.getCurrentUrl().equals(expectUrl));
	}
	
	@Test
	public void canDisplaySvtProProductPage() {
		
		String expectUrl = this.baseUrl+"/products/pro/";
		
		new SeleniumAmpegHomePage(driver, baseUrl)
		.clickProductPage()
		.clickSvtProPage();
			
		assertTrue("Not navigate to the expected URL"+ expectUrl, this.driver.getCurrentUrl().equals(expectUrl));
	}
	
	@Test
	public void canDisplayClassicProductPage() {
		
		String expectUrl = this.baseUrl+"/products/classic/";
		
		new SeleniumAmpegHomePage(driver, baseUrl)
		.clickProductPage()
		.clickClassicSeriesPage();
		
		assertTrue("Not navigate to the expected URL"+ expectUrl, this.driver.getCurrentUrl().equals(expectUrl));
	}
	
	@Test
	public void canDisplaySvt3proProductPage() {
		
		String expectUrl = this.baseUrl+"/products/pro/svt3pro/";
		
		new SeleniumAmpegHomePage(driver, baseUrl)
		.clickProductPage()
		.clickSvtProPage()
		.clickSvtProduct();
			
		assertTrue("Not navigate to the expected URL"+ expectUrl, this.driver.getCurrentUrl().equals(expectUrl));
	}
	
	@Test
	public void canDisplaySvt410hlfProductPage(){
		
		String expectUrl = this.baseUrl+"/products/classic/svt410hlf/";
		
		new SeleniumAmpegHomePage(driver, baseUrl)
		.clickProductPage()
		.clickClassicSeriesPage()
		.clickSVT410HLFDetailPage();
		
		assertTrue("Not navigate to the expected URL"+ expectUrl, this.driver.getCurrentUrl().equals(expectUrl));
	}
	
	@Test
	public void canClickHomeBreadcrumbLink() {

		String expectUrl = "https://ampeg.com/index.html";
		
		new SeleniumAmpegHomePage(driver, baseUrl)
		.clickProductPage()
		.clickSvtProPage()
		.clickSvtProduct()
		.clickHomepage();
	
		assertTrue("Not navigate to the expected URL"+ expectUrl, this.driver.getCurrentUrl().equals(expectUrl));	
	}
	
	@Test
	public void checkProductWeightInSvt410Page(){
		
		String expetdText="Handling Weight: 85 Pounds";
		
		new SeleniumAmpegHomePage(driver, baseUrl)
		.clickProductPage()
		.clickClassicSeriesPage()
		.clickSVT410HLFDetailPage();
		
		String Svt410HandlingText=new SVT410HLFDetailPage(driver, baseUrl).returnTheHandlingweightValue();
		
		assertEquals(expetdText, Svt410HandlingText);
	}
}