package shadowdom_svg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDomSVG {
	
	
	public static WebDriver driver;
	
	@Test
	public void shadowRootSVG() throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	driver.get("https://books-pwakit.appspot.com/");
	driver.manage().window().maximize();
	
	SearchContext shadow1 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
	
	Thread.sleep(1000);
	shadow1.findElement(By.cssSelector("#input")).sendKeys("book");
	
	
	SearchContext shadow2 = shadow1.findElement(By.cssSelector("book-input-decorator")).getShadowRoot();
	
	Thread.sleep(1000);
	shadow2.findElement(By.cssSelector("svg")).click();
	
	
	Thread.sleep(3000);
	
	
	
	
	}

}
