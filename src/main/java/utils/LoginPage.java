package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	//constructor - will initialize the web driver because if you want to locate a web element
	//we have to write a find element method when you write a find element method we need 
	//a driver also
	
	//driver i will pass from test case also
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	//locators
	By username = By.name("username");
	By password = By.name("password");
	By login = By.xpath("//button[@type='submit']");

	//action methods
    public void setUserName(String userName) {
    	driver.findElement(username).sendKeys(userName);
    }
    
    public void setPassword(String passWord) {
    	driver.findElement(password).sendKeys(passWord);
    }
    
    public void clickLogin() {
    	driver.findElement(login).click();
    }
}
