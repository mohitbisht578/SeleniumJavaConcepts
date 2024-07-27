package webtable;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebTable_Assigment {
		
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, ParseException {
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://blazedemo.com/");
			
			//1. choose departure destination city 2.//find lowest price in a table
			//3. choose flight //4. fill all details //5. purchase flight
			
			WebElement departureCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
			Select select = new Select(departureCity);
			
			select.selectByVisibleText("Mexico City");
			
			WebElement destinationCity = driver.findElement(By.xpath("//select[@name='toPort']"));
			Select select1 = new Select(destinationCity);
			
			select1.selectByVisibleText("New York");
			
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			//find all price
			
			int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
			
		    List<String> list = new ArrayList<String>();
			
			for(int i=1; i<rows; i++) {
				
				String price = driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]/td[6]")).getText();
				
				list.add(price);
				
			}
			
			Collections.sort(list);
			String sortPrice = list.get(0);
			
			driver.findElement(By.xpath("//td[text()='"+sortPrice+"']/parent::tr//td/input[@type='submit']")).click();
			
			Select selectCard = new Select(driver.findElement(By.xpath("//select[@id='cardType']")));
			//fill form
			driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Tom");
			driver.findElement(By.xpath("//input[@id='address']")).sendKeys("123 Main St.");
			driver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York");
			driver.findElement(By.xpath("//input[@id='state']")).sendKeys("US");
			driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("12345");
			selectCard.selectByVisibleText("American Express");
			driver.findElement(By.xpath("//input[@id='creditCardMonth']")).clear();
			driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("7");
			driver.findElement(By.xpath("//input[@id='creditCardYear']")).clear();
			driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2024");
			driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("987654321");
			driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Tom");
			driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
			driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
			
			String text = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
			
			Assert.assertEquals(text, "Thank you for your purchase today!");
	}
	

}
