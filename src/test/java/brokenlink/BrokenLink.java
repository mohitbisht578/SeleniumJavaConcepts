package brokenlink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLink {
	
	//broken link is a link which does not have any resource in the server
	//that will return status code >= 400 that is a broke link
	//if it is a less than 400 then it is not a broken link
	//url HttpUrlConnection open connection
	
	@Test
	public void brokenLink() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com");
		driver.manage().window().maximize();
		
		//capture all the links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total number of links : " + links.size());
		
		//href should have value
		int noOfBrokenLinks = 0;
		for(WebElement link : links) {
			
			String hrefValue  = link.getAttribute("href");
			
			if(hrefValue==null || hrefValue.isEmpty()) {
				System.out.println(hrefValue + "==>" + "href attribute value is null or empty. So not possible to check");
				continue;
			}
			
			//hit url to server //converted href value from string to URL format
			try{
				URL linkUrl = new URL(hrefValue);
				
				//connection to server
				HttpURLConnection connection = (HttpURLConnection)linkUrl.openConnection(); 
				connection.connect();
				
				if(connection.getResponseCode() >= 400) {
					
					System.out.println(hrefValue + "====> Broken link");
					noOfBrokenLinks++;
				}
				else {
					System.out.println(hrefValue + "====> Not a broken link");
				}
			}
			
			catch(Exception e) {
				
			}
			
		}
		
		System.out.println("Number of broken links : " + noOfBrokenLinks);
		
	}

}
