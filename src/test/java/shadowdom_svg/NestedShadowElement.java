package shadowdom_svg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NestedShadowElement {
	
	public static WebDriver driver;
	
	@Test
	public void shadowRootTest() throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	driver.get("https://selectorshub.com/xpath-practice-page/");
	driver.manage().window().maximize();
		
	Thread.sleep(3000);
	
	SearchContext shadowRoot1 = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
	
	SearchContext shadowRoot2 = shadowRoot1.findElement(By.cssSelector("#app2")).getShadowRoot();
	
	Thread.sleep(2000);
	
    shadowRoot2.findElement(By.cssSelector("#pizza")).sendKeys("dominoz");
	
	Thread.sleep(2000);

	}
}
