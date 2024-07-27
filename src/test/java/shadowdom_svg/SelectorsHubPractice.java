package shadowdom_svg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectorsHubPractice {
	
public static WebDriver driver;
	
	@Test
	public void shadowRootTest() throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	driver.get("https://selectorshub.com/xpath-practice-page/");
	driver.manage().window().maximize();
		
	Thread.sleep(3000);
	
	SearchContext shadowRoot = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
	Thread.sleep(1000);
    shadowRoot.findElement(By.cssSelector("#kils")).sendKeys("mohit");
	
	Thread.sleep(2000);
	
	
	}

}
