package chromeoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class IcognitoMode {
	
	@Test
	public void headlessTest() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		
//		String actual_title = driver.getTitle();
//		System.out.println(actual_title);
//		
//		if(actual_title.contains("expired")) {
//			System.out.println("test passed");
//		}
//		else {
//			System.out.println("test failed");
//		}
//		
		Thread.sleep(3000);
		driver.quit();
	}

}
