package chromeoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessTesting {
	
	@Test
	public void headlessTest() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
		
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		
		if(actual_title.contains("Shopping")) {
			System.out.println("test passed");
		}
		else {
			System.out.println("test failed");
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}
