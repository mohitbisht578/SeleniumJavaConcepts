package webtable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTable_Pagination {
	
        @Test
        public void test() throws InterruptedException {
 		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		driver.manage().window().maximize();
		
		//find all the names
		
		List<WebElement> namesElement = driver.findElements(By.cssSelector("#example > tbody > tr > td:nth-child(1)"));
		
		List<String> names = new ArrayList<String>();
		
		for(WebElement e : namesElement) {
			names.add(e.getText());
		}
		
		String nextButtonClassName = driver.findElement(By.cssSelector("button[aria-label='Next']"))
				.getAttribute("class");
		
		while(!nextButtonClassName.contains("disabled")) {
			
			driver.findElement(By.cssSelector("button[aria-label='Next']")).click();
			namesElement = driver.findElements(By.cssSelector("#example > tbody > tr > td:nth-child(1)"));
			
			for(WebElement e : namesElement) {
				names.add(e.getText());
			}
			
			nextButtonClassName = driver.findElement(By.cssSelector("button[aria-label='Next']"))
					.getAttribute("class");
		}
			
		for(String name : names) {
			System.out.println(name);
		}
		
		int totalNames = names.size();
		System.out.println("Total number of names : " + totalNames);
		
		String totalEntry = driver.findElement(By.xpath("//div[@id='example_info']")).getText().split(" ")[5];
		
		//int totalEntry = Integer.parseInt(total.substring(total.indexOf("of")+1, total.indexOf("entries")-1));
		
		System.out.println("Total number of displayed entry : " + totalEntry);
		
		Assert.assertEquals(Integer.parseInt(totalEntry), totalNames);
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
