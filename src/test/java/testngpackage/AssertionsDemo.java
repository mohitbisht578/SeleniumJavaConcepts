package testngpackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsDemo {
	
	SoftAssert sa = new SoftAssert();
	
	@Test
	public void softAssert() {
		
		System.out.println("test 1");
		System.out.println("test 2");
		
		sa.assertEquals(1, 2); //soft assert
		
		System.out.println("test 3");
		System.out.println("test 4");
		
		sa.assertAll(); //mandatory
		
		
	}

}
