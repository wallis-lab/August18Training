import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVT410HLFDetailPage extends PageObject{
	protected SVT410HLFDetailPage(ChromeDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String returnTheHandlingweightValue() {
		WebElement element = this.driver.findElement(By.xpath("//div[@class='specsCopy']"));
		
		String[] segments = element.getText().split("\n");
		
		return segments[segments.length - 1];
	}
}
