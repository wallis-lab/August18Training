package test.java.DemoQa.pageObjects;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.DemoQa.framework1.DemoqaPageObject1;

public class DemoqaLinksPage extends DemoqaPageObject1{
	String search_handle;
	String saveMainHandle;
	String second_handle;
	//Set<String> handles;
	ArrayList<String> lst;
	//Set<String> handles;
	public DemoqaLinksPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		search_handle = driver.getWindowHandle();
		//Set<String> handles = driver.getWindowHandles();
	}
	
	public DemoqaLinksPage clickHomeHyperLink() throws InterruptedException {
		
		WebElement RadioButtonElement = getPageHyperLinkElement("simpleLink");
		RadioButtonElement.click();
		/*Thread.sleep(2000);
		handles = driver.getWindowHandles();*/
		/*search_handle = driver.getWindowHandle();
		System.out.println(search_handle);*/
		
		return new DemoqaLinksPage(this.driver, this.baseUrl);
	}
	
	public DemoqaLinksPage clickNewPageJoinNowButton() throws InterruptedException{
			//second_handle=search_handle;
		Set<String> handles = driver.getWindowHandles();
			    for (String handle : handles) {
			    	
			    	//System.out.println("nida       "+handle);
			    	if(handle != search_handle) {
			    		//System.out.println("diyi ci "+search_handle);
			    		driver.switchTo().window(handle);
			    		Thread.sleep(2000);
			    		//System.out.println(handle);	
			    		second_handle=handle;		    	
			    	}
			    	else {
			    		saveMainHandle=handle;
			    	}
			    }
			    
			    lst = new ArrayList<String>(handles);
		        
			       // System.out.println("duoshao  "+lst.size());
			       // System.out.println("wo shi shui "+lst.get(1));
			        
			    WebElement RadioButtonElement = getJoinNowElement("banner-image");
				
	    		RadioButtonElement.click();
	    		driver.close();

		return new DemoqaLinksPage(this.driver, this.baseUrl);
	}
	
	public DemoqaLinksPage clickCreatedHyperLink() throws InterruptedException {
		
		//driver.switchTo().window(search_handle);
		/*lst = new ArrayList<String>(handles);
		System.out.println("wo shi shui 1  "+lst.get(1));
		System.out.println("wo shi shui 2 "+lst.get(0));
		System.out.println("wo shi shui 3 "+lst.get(2));*/
		
		for (String handle : handles) {
	    	
	    	System.out.println("nida       "+handle);
	    	if(handle != search_handle) {
	    		//System.out.println("diyi ci "+search_handle);
	    		driver.switchTo().window(handle);
	    		Thread.sleep(2000);
	    		//System.out.println(handle);	
	    		second_handle=handle;		    	
	    	}
	    	else {
	    		saveMainHandle=handle;
	    	}
	    }
        //driver.switchTo().window(lst.get(0));
        
		/*String handle3 = getLastHandle(driver);
		   Set<String> handles1 = driver.getWindowHandles();
		    for (String handle : handles1) {
		    	//System.out.println("nida       "+handle);
		    	if(handle != handle3) {
		    		//System.out.println(search_handle);
		    		driver.switchTo().window(handle);
		    		//Thread.sleep(2000);
		    		//System.out.println(handle);		
		    	}
		    }*/
		//driver.switchTo().window(second_handle);
		//System.out.println("di er ci "+search_handle);
		WebElement RadioButtonElement = getPageHyperLinkElement("created");
		//driver.switchTo().frame("//div[@id='linkWrapper']");
		RadioButtonElement.click();
		
		return new DemoqaLinksPage(this.driver, this.baseUrl);
	}
	
	 public static String getLastHandle(WebDriver driver) {
	        //获取当前打开窗口的所有句柄
	        Set<String> Allhandles = driver.getWindowHandles();
	        ArrayList<String> lst = new ArrayList<String>(Allhandles);
	        return lst.get(lst.size()-1);
	    }


	public WebElement getPageHyperLinkElement(String HomeHyperLinkElement) {

		return driver.findElement(By.xpath("//a[@id='"+ HomeHyperLinkElement + "']"));
	}
	
	public WebElement getJoinNowElement(String JoinNowElement) {

		return driver.findElement(By.xpath(".//img[@class='"+JoinNowElement+"']"));
	}
	
	public DemoqaLinksPage clickJoinpage() {
		/*WebElement RadioButtonElement = driver.findElement(By.xpath(".//img[@class='banner-image']"));
		RadioButtonElement.click();
		return new DemoqaLinksPage(this.driver, this.baseUrl);*/
		
		WebElement RadioButtonElement = getPageHyperLinkElement("created");
		//driver.switchTo().frame("//div[@id='linkWrapper']");
		RadioButtonElement.click();
		return new DemoqaLinksPage(this.driver, this.baseUrl);
		
		
	}

	

}
