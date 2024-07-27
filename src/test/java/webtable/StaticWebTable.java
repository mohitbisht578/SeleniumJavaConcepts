package webtable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {
	
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://testautomationpractice.blogspot.com/");
		//	driver.manage().window().maximize();
			
			//1. find total no of rows
			
			List<WebElement> totalRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
			System.out.println("Total number of rows : " + totalRows.size());
			
//			for(WebElement e : totalRows) {
//				
//				System.out.println(e.getText());
//			}
//			
			//find total no of columns
			List<WebElement> totalCols = driver.findElements(By.xpath("//table[@name='BookTable']//tr/th"));
			System.out.println("Total number of columns : " + totalCols.size());
			
			
			//read data from specific rows and cols //5 row col 1
			
//			for(int i=2; i<=totalRows.size(); i++) {
//				
//				for(int j=1; j<=totalCols.size(); j++) {
//					
//					String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td["+j+"]")).getText();
//					System.out.print(value + " ");
//				}
//				
//				System.out.println();
//			}
//			
			//print data whose author is mukesh
			
//			for(int i=2; i<=totalRows.size(); i++) {
//				
//			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[2]")).getText();
//			
//			if(author.equals("Mukesh")) {
//				
//				String book = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[1]")).getText();
//				
//				System.out.println(book + " " + author);
//			}
//			
//		//	System.out.println(author + " ");
//			
//			}
		
			//find total price of books
			int totalPrice = 0;
			for(int i=2; i<=totalRows.size(); i++) {
				
				String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[4]")).getText();
				
				totalPrice += Integer.parseInt(price);
				
			}
		
				System.out.println(totalPrice);
			//	if(author.equals("Mukesh")) {
					
			//		String book = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[1]")).getText();
					
				//	System.out.println(price);
			//	}
			
		//	}
			
	}

}
