package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
	//	driver.findElement(By.xpath("//div[@class='oxd-select-wrapper']")).click();
		
		driver.findElement(By.xpath("//label[normalize-space()='Job Title']"
				+ "/parent::div/parent::div//div[@class='oxd-select-wrapper']")).click();
		
	//	driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[text()='Finance Manager']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='oxd-select-option']/span"));
		
		for(WebElement e : list) {
			
		//	System.out.println(e.getText());
			
			String text = e.getText();
			
			if(text.equals("Finance Manager") || text.equals("Customer Success Manager")) {
				
				e.click();
			}
		}
		
	}

}
