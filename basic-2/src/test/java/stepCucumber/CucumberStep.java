package stepCucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ampeg.foundation.AmpegTestBase;
import ampeg.pageObjects.AmpegClassicSeriesPage;
import ampeg.pageObjects.AmpegHomePage;
import ampeg.pageObjects.AmpegProductPage;
import ampeg.pageObjects.SVT410HLFDetailPage;
import ampeg.pageObjects.SvtProPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStep{

	WebDriver driver = null;
	String baseUrl = "https://ampeg.com/index.html";
	
	@Given("I am on the home page of the Ampeg website")
	public void goHomePage() {
		driver = new ChromeDriver();
		driver.get(baseUrl);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("I click the product page")
	public void clickProductPage() {
		new AmpegHomePage(driver, baseUrl).clickProductPage();
	}

	@When("at the product page I click Svt Pro Series")
	public void clickSvtProduct() {
		new AmpegProductPage(driver, baseUrl).clickSvtProPage();
	}

	@When("at the svt pro page click the SVT-3PRO")
	public void click3Prop() {
		new SvtProPage(driver, baseUrl).clickSvtProduct();
	}
	
	@When("at the product page I click classic Series product")
	public void clickClassicProduct() {
		new AmpegProductPage(driver, baseUrl).clickClassicSeriesPage();
	}

	@When("at the svt pro page click the SVT-410HLF product")
	public void clicksvt410Prop() {
		new AmpegClassicSeriesPage(driver, baseUrl).clickSVT410HLFDetailPage();
	}

	@When("look the handing weight should {string}")
	public void clickHomePage(String string) {
		String Svt410HandlingText=new SVT410HLFDetailPage(driver, baseUrl).returnTheHandlingweightValue();
		
		assertEquals(string, Svt410HandlingText);
	}

	@When("click the Home page button")
	public void clickHomePage() {
		String expectUrl = "https://ampeg.com/index.html";
		new SvtProPage(driver, baseUrl).clickHomepage();
		assertTrue("Not navigate to the expected URL"+ expectUrl, this.driver.getCurrentUrl().equals(expectUrl));
	}
	
	@Then("close the brower")
	public void close() {
		driver.close();
	}
}
