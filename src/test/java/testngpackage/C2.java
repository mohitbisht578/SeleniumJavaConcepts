package testngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {
//
//	this is before test
//	this is abc
//	this is xyz
//	this is after test

	@Test
	public void xyz() {
		
		System.out.println("this is xyz");
	}
	
	@AfterTest
	public void at() {
		
		System.out.println("this is after test");
	}
}
