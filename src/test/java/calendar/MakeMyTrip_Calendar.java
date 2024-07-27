package calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTrip_Calendar {

public static WebDriver driver;
	
	@Test
	public void calendarTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//span[normalize-space()='Departure'])[1]")).click();
		
		Thread.sleep(2000);
		
		String monthYearVal = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		System.out.println(monthYearVal);
		
		String month = monthYearVal.split(" ")[0];
		String year = monthYearVal.split(" ")[1];
		
		while(!(month.equals("April") && year.equals("2025"))) {
			
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			monthYearVal = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			System.out.println(monthYearVal);
			
			month = monthYearVal.split(" ")[0];
			year = monthYearVal.split(" ")[1];
		}
		
		driver.findElement(By.xpath("(//p[contains(text(),'29')])[1]")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
}
