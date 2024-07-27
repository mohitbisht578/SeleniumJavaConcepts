package calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Booking_CalendarTest {
	
	public static WebDriver driver;
	
	@Test
	public void calendarTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://www.booking.com/");
		driver.manage().window().maximize();
		
		 driver.findElement(By.xpath("//button[@aria-label='Dismiss sign in information.']")).click();
		//driver.switchTo().alert().dismiss();
			Thread.sleep(2000);
			
		driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']")).click();
//		if(attribute.equals("date-display-field-start")) {
//			driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']")).click();
//		}
		
//		String checkInMonth = "January 2025";
//		String date = "32";
//	    while(true) {
//			
//		//String month = driver.findElement(By.xpath("//h3[normalize-space()='"+checkInMonth+"']")).getText();
//	    	String month = driver.findElement(By.xpath("//h3[@aria-live='polite']")).getText();
//			System.out.println(month);
//			
//			if(month.equalsIgnoreCase(checkInMonth)) {
//				break;
//			}
//			else {
//				driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
//			}
//	    }
//		//	Thread.sleep(2000);
//		//	String text1 = driver.findElement(By.xpath("//span[@aria-label='"+date+" "+checkInMonth+"']")).getText();
//			
//			//if(text1.equals(date)) {
//	    
//				try {
//				driver.findElement(By.xpath("//span[@aria-label='"+date+" "+checkInMonth+"']")).click();
//				}
//				catch(Exception e) {
//					System.out.println("INVALID DATE");
//				}
		//	}
		
	   
		
		
	//	Thread.sleep(2000);
	//	driver.quit();
		String checkInMonth = "July 2025";
		String date = "34";
		
		selectDate(checkInMonth, date);
		
	}
	
	public static void selectDate(String checkInMonth, String date) {
		
		while(true) {
			String month = driver.findElement(By.xpath("//h3[@aria-live='polite']")).getText();
				//System.out.println(month);
				
				if(month.contains("February") && Integer.parseInt(date) > 29) {
				    System.out.println("WRONG DATE: " + checkInMonth + " : " + date);
					return;
				}
				
				if(Integer.parseInt(date) > 31) {
					 System.out.println("WRONG DATE: " + checkInMonth + " : " + date);
						return;
				}
				
				if(month.equalsIgnoreCase(checkInMonth)) {
					break;
				}
				else {
					driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
				}
		    }    
				try {
					driver.findElement(By.xpath("//span[@aria-label='"+date+" "+checkInMonth+"']")).click();
					}
					catch(Exception e) {
						System.out.println("INVALID DATE");
					}
			}

}
