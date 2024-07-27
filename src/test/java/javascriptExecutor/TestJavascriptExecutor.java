package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.Test;

public class TestJavascriptExecutor {
	
	@Test
	public void scroll() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.godaddy.com/en-in");
		driver.get("https://www.myntra.com/men-tshirts");
		driver.manage().window().maximize();
		
		JavaScriptExecutor.scrollMiddlePage(driver);
		
		driver.findElement(By.cssSelector(".brand-more")).click();
		
	//	WebDriver driver = new EventFiringDecorator(listener).decorate(driver);
		
		
//		JavaScriptExecutor.scrollLastPage(driver);
//		
//		Thread.sleep(2000);
//		
//		JavaScriptExecutor.scrollStartingPage(driver);
//		
//		Thread.sleep(2000);
//		
//		WebElement element = driver.findElement(By.xpath("//a[contains(.,'Get Help')]"));
//		JavaScriptExecutor.scrollIntoView(driver, element);
//		
//		Thread.sleep(2000);
//		
//		element.click();
//		
		Thread.sleep(2000);
		driver.quit();
	}

}
