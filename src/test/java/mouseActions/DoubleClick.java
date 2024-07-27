package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick {
	
	@Test
	public void mouse() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
	driver.manage().window().maximize();
	
	driver.switchTo().frame("iframeResult");
	WebElement field1 = driver.findElement(By.id("field1"));
	WebElement field2 = driver.findElement(By.id("field2"));
	WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
	
	field1.clear();
	field1.sendKeys("WELCOME");
	String fiedl1Text = field1.getText();
	
	Actions actions = new Actions(driver);
	actions.doubleClick(element).perform();
	
	String field2Text = field2.getText();
	
	Assert.assertEquals(fiedl1Text, field2Text);
	
	Thread.sleep(2000);
	
	driver.quit();
	}

}
