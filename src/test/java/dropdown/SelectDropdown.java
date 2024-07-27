package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
	//	driver.manage().window().maximize();
		
		WebElement country = driver.findElement(By.id("country"));
		Select select = new Select(country);
		
		select.selectByValue("germany");
		select.selectByIndex(5);
		select.selectByVisibleText("India");
		
		List<WebElement> countryList = select.getOptions();
		
		System.out.println(countryList.size());
		
//		for(WebElement e : countryList) {
//			
//			System.out.println(e.getText());
//		}
		
		for(int i=0; i<countryList.size(); i++) {
			System.out.println(countryList.get(i).getText());
		}
		
	}

}
