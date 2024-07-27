package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActions {
	
	@Test
	public void mouse() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://demo.opencart.com/");
	driver.manage().window().maximize();
	
	WebElement desktops = driver.findElement(By.xpath("//a[text()='Desktops']"));
	WebElement macs = driver.findElement(By.xpath("//a[text()='Desktops']"));
	Actions actions = new Actions(driver);
	
	actions.moveToElement(desktops)
		   .moveToElement(macs)
		   .click()
		   .build()
		   .perform();
	
	//perform method can do create(build) and complete the action
	actions.moveToElement(desktops)
	   .moveToElement(macs)
	   .click()
	   .perform();
	
}

}
