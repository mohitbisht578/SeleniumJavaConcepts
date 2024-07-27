package testngpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
	
	WebDriver driver;

//	@BeforeClass
//	public void setUp() throws InterruptedException {
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().window().maximize();
//		Thread.sleep(2000);
//	}
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser) throws InterruptedException {
		
		switch(browser.toLowerCase()) {
		
		case "chrome":
		driver = new ChromeDriver();
		break;
		
		case "firefox":
		driver = new FirefoxDriver();
		break;
		
		case "edge":
		driver = new EdgeDriver();
		break;
		
		case "safari":
		driver = new SafariDriver();
		break;
		
		default: 
		System.out.println("Invalid browser");
		return;
	}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void validateLogo() {
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		AssertJUnit.assertEquals(status, true);
	}
	
	@Test(priority=2)
	public void validateTitle() {
		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, "OrangeHRM");
	}
	

	@Test(priority=3)
	public void validateUrl() {
		String url = driver.getCurrentUrl();
		AssertJUnit.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	

}
