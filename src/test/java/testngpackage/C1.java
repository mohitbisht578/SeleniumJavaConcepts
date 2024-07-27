package testngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
	
//	this is before test
//	this is abc
//	this is xyz
//	this is after test

	
	@Test
	public void abc() {
		
		System.out.println("this is abc");
	}
	
	@BeforeTest
	public void bt() {
		
		System.out.println("this is before test");
	}

}
