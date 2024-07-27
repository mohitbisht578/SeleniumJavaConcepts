package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestedDropdown_Bjs {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://bjs.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("search")).sendKeys("iphone");
		
		Thread.sleep(2000);
		
		List<WebElement> list = driver.findElements(By.xpath("//a[@auto-data='searchBar_searchRedirectedPage']/span"));
		System.out.println(list.size());
		
		for(WebElement e : list) {
			
			String text = e.getText();
			System.out.println(text);
			if(text.equals("iphone")) {
				e.click();
				break;
			}
		}
		
}
				

}
