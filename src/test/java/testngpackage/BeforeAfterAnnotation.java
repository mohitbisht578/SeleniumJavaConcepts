package testngpackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//class level
public class BeforeAfterAnnotation {
	
	/* 
		login
		advanced search
		logout
		
		login
		search
		logout 
	*/

	//before and after method will repeat as per the @test
	//if
	
	//login and logout will run only once
	@BeforeClass
	public void login() {
		System.out.println("login");
	}
	
	@Test
	public void search() {
		System.out.println("search");
	}
	
	@Test
	public void advancedSearch() {
		System.out.println("advanced search");
	}
	
	@AfterClass
	public void logout() {
		System.out.println("logout");
	}

}
