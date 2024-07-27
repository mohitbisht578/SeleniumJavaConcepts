package calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumPractise_CalendarTest {
	
public static WebDriver driver;
	
	@Test
	public void calendarTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("datepicker")).click();
		//driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		
//		String monthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//		System.out.println(monthYear);
//		String month = monthYear.split(" ")[0];
//		String year = monthYear.split(" ")[1];
//		
//		while(!(month.equals("October") && year.equals("2025"))) {
//			
//			driver.findElement(By.xpath("//span[text()='Next']")).click();
//			
//			monthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//			System.out.println(monthYear);
//			month = monthYear.split(" ")[0];
//			year = monthYear.split(" ")[1];
//		}
//			
//			driver.findElement(By.xpath("//a[text()='25']")).click();
			
			selectDate("32", "July", "2024");
	}
	
	public static String[] getMonthYear(String monthYear) {
		return monthYear.split(" ");
	}
	
	public static void selectDate(String day, String month, String year) {
		
		if(month.equals("February") && Integer.parseInt(day)>29) {
			System.out.println("WRONG DATE");
			return;
		}
		
		if(Integer.parseInt(day)>31) {
			System.out.println("WRONG DAY");
			return;
		}
		
		String monthYearVal = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		System.out.println(monthYearVal);
		
		while(!(getMonthYear(monthYearVal)[0].equals(month) 
					&& getMonthYear(monthYearVal)[1].equals(year))) {
				
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			monthYearVal = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		}
			
			driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	}
}
