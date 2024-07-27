package shadowdom_svg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SvgTest {
	
public static WebDriver driver;
	
	@Test
	public void svgTest() throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	driver.get("https://www.tricentis.com/");
	driver.manage().window().maximize();

	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[@title='Twitter']//*[name()='svg']")).click();
	
	Thread.sleep(2000);
	
	driver.quit();
	
	
	
	}
}
