package testngpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="login")
	public void test(String username, String password) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
	}
	
	//return two dimesional object
//	@DataProvider
//	public Object[][] loginData() {
//		
//		Object data[][] = { 
//				
//				{"abc@gmail.com", "test123"},
//				{"xyz@gmail.com", "test012"},
//				{"john@gmail.com", "test@123"},
//				{"pavanol123@gmail.com", "test@123"},
//				{"johncanedy@gmail.com", "test"}
//		};
//		
//		return data;
//				
//	}
	
	@DataProvider(name="login", indices= {0, 3, 4})
	public Object[][] loginData() {
		
		Object data[][] = { 
				
				{"abc@gmail.com", "test123"},
				{"xyz@gmail.com", "test012"},
				{"john@gmail.com", "test@123"},
				{"pavanol123@gmail.com", "test@123"},
				{"johncanedy@gmail.com", "test"}
		};
		
		return data;
				
	}
	
	
	@AfterClass
	public void teardDown() {
		driver.close();
	}

}
