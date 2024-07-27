package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
			
			driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
			
			Thread.sleep(2000);
			
			//1.  select single option
			driver.findElement(By.xpath("//input[@value='Bootstrap']")).click();
			
			//2 capture all options and find out size
			
			List<WebElement> optionsList = driver.findElements(By.xpath("//a/label"));
			
//			for(WebElement e : optionsList) {
//				System.out.println(e.getText());
//			}
			
			for(WebElement e : optionsList) {
				String option = e.getText();
				
				if(option.equals("Java") || option.equals("Python") || option.equals("MySQL")) 
				{
					e.click();
				}
				
//				if(text.contains("Java")) {
//					e.click();
//				}
//				
//				if(text.contains("Python")) {
//					e.click();
//				}
				
			}
			
//			
			Thread.sleep(2000);
			
			driver.close();
			
	}

}
