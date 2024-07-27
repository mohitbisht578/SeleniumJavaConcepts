package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	
	@Test
	public void mouse() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	driver.manage().window().maximize();
	
	WebElement source = driver.findElement(By.xpath("//div[@id='box6']"));
	
	WebElement target =  driver.findElement(By.xpath("//div[text()='Italy']"));
	
	Actions actions = new Actions(driver);
	
	actions.dragAndDrop(source, target).perform();
	
	Thread.sleep(2000);
	
	driver.quit();
	
	
	
	}

}
