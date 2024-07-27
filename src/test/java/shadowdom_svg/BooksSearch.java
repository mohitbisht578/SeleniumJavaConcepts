package shadowdom_svg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BooksSearch {
	
	public static WebDriver driver;
	
	@Test
	public void shadowRootTest() throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	driver.get("https://books-pwakit.appspot.com/");
	driver.manage().window().maximize();
		
	Thread.sleep(3000);
	
	//This Element is inside single shadow DOM.
//	String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
//	Thread.sleep(1000);
	SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
	Thread.sleep(1000);
	shadow.findElement(By.cssSelector("#input")).sendKeys("book");
	
	Thread.sleep(2000);

	
	}
}
