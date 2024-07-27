package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClick {
	
	
	@Test
	public void mouse() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
	driver.manage().window().maximize();
	
	WebElement element = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
	Actions actions = new Actions(driver);
	
	//right click action
	actions.contextClick(element).perform();
	
	
	//click copy
	driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
	
	Thread.sleep(2000);
	
	//accept alert
	driver.switchTo().alert().accept();

	

	}
}
