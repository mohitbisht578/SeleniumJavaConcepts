package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelector {
	
	public static void main(String[] args) throws InterruptedException {
		
			//input id //inputx //input tag is optional
		//tag#id //tag.classname //tag[attribute='value'] 
		//tag.classname[attribute="value"]
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//method chaining - manage, window, maximize
		//Option interface
		//Window interface - //maximize
		
		driver.get("https://demo.nopcommerce.com/");
		
		//send keys
//		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
//		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		
		//tag attribute
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
