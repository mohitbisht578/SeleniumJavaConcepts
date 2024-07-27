package frame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameTest {
	
	@Test
	public void frameTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//frame1
		WebElement frame1 = driver.findElement(By.cssSelector("frame[src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.cssSelector("input[name='mytext1']")).sendKeys("welcome");

		//back to normal
		driver.switchTo().defaultContent();
		
		//frame2
		WebElement frame2 = driver.findElement(By.cssSelector("frame[src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		
		driver.findElement(By.cssSelector("input[name='mytext2']")).sendKeys("hello");
		Thread.sleep(2000);
		
		//back to normal
		driver.switchTo().defaultContent();
		
		//frame 3
		WebElement frame3 = driver.findElement(By.cssSelector("frame[src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.cssSelector("input[name='mytext3']")).sendKeys("world");
		
		//back to normal
		driver.switchTo().defaultContent();
				
		//frame 4
		WebElement frame4 = driver.findElement(By.cssSelector("frame[src='frame_4.html']"));
		driver.switchTo().frame(frame4);
				
		driver.findElement(By.cssSelector("input[name='mytext4']")).sendKeys("hi");
		
		//back to normal
		driver.switchTo().defaultContent();
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}
