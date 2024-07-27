package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
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
		driver.close();
	}

}
