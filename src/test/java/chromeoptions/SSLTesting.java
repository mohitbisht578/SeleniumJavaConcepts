package chromeoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SSLTesting {
	
	//Secure Socket Layer Handling //SSL Handling
	//website needs ssl acceot certificate
	@Test
	public void headlessTest() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		
		if(actual_title.contains("expired")) {
			System.out.println("test passed");
		}
		else {
			System.out.println("test failed");
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}
