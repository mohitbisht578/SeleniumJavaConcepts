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

public class Haandle {

	 @Test
     public void test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://www.myntra.com/kids-footwear?f=Categories%3AHeels&plaEnabled=false");
	//	driver.get("https://www.myntra.com/bath-robes?f=Brand%3AELEVANTO");
		
		driver.get("https://www.myntra.com/kids?f=Categories%3ABaby%20Photoshoot%20Props%2CBaby%20Pillow%3A%3AGender%3Aboys%2Cboys%20girls");
		driver.manage().window().maximize();
		
		List<WebElement> productName = driver.findElements(By.cssSelector(".product-productMetaInfo > h4.product-product"));
		
		//List<WebElement> productName = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']//h4[@class='product-product']"));
		List<String> list = new ArrayList<String>();
		
		for(WebElement e : productName) {
			
			list.add(e.getText());
			
		}
		
		WebElement nextButton = driver.findElement(By.cssSelector(".pagination-next"));
		
		while(true) {
			
			// driver.findElement(By.cssSelector(".pagination-next")).click();
			
			 nextButton.click();
			 Thread.sleep(2000);
			
			 productName = driver.findElements(By.cssSelector(".product-productMetaInfo > h4.product-product"));
		
			// productName = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']//h4[@class='product-product']"));
			
			 for(WebElement e : productName) {
					
					list.add(e.getText());
					
				}
			 
			// nextButtonClassName = driver.findElement(By.cssSelector(".pagination-next")).getAttribute("class"); 
			 
			 try {
				 nextButton = driver.findElement(By.cssSelector(".pagination-next"));
			 }
			 catch(Exception e) {
				 System.out.println("NO MORE PRODUCTS LEFT");
				 break;
			 }
		}
		
		System.out.println("------------------------------------");
		for(String name : list) {
			
			System.out.println(name);
			
		}
		
		int totalNames = list.size();
		System.out.println("Total number of names : " + totalNames);
		
//		String totalPagination = driver.findElement(By.cssSelector(".pagination-paginationMeta"))
//								.getText().split(" ")[3];
		
		String totalItems = driver.findElement(By.cssSelector(".title-count")).getText().split(" ")[2];
		System.out.println("Total number of displayed pagination : " + totalItems);
		
		Assert.assertEquals(Integer.parseInt(totalItems), totalNames);
			
		driver.close();
		
	 }
	
	
}
