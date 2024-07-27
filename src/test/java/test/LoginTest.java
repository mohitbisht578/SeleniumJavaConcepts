package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.LoginPage;

public class LoginTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("admin");
		loginPage.setPassword("admin123");
		loginPage.clickLogin();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
