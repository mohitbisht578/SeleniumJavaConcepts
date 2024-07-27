package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Links {
	
	WebDriver driver;
	
	@Test
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	
	
	//public static void main(String[] args) {
		
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.demoblaze.com/index.html");
//		
//		//getting all links
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		for(WebElement link : links) {
//			System.out.println(link.getText());
//		}
//		
//		System.out.println("all images in page");
//		//getting all images
//		List<WebElement> images = driver.findElements(By.tagName("img"));
//		for(WebElement image : images) {
//			System.out.print(image.getText());
//			//System.out.print(image.getAttribute("src"));
//	//	}
		
		driver.close();
	}

}
