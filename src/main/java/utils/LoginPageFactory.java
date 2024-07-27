package utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

	WebDriver driver;
	
	public LoginPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//find by is finding the web element
	//PageFactory is pre-defined class initElements make sure 
	//is applicable for all elements locators internally
	//locators and findig the element
	
	@FindBy(name="username") 
	WebElement username;
	
	@FindBy(name="password") 
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']") 
	WebElement login;
	
	@FindBy(tagName = "a")
	List<WebElement> links;
	
	//locators
//	By username = By.name("username");
//	By password = By.name("password");
//	By login = By.xpath("//button[@type='submit']");
	
	//action methods
	public void setUserName(String userName) {
		//driver.findElement(username).sendKeys(userName);
		username.sendKeys(userName);
	}
	
	public void setPassword(String passWord) {
		password.sendKeys(passWord);
	}
	
	public void clickLogin() {
		login.click();
	}

	
}
