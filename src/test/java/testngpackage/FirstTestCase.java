package testngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class FirstTestCase {
	
	
	@Test(priority=0)
	public void b() {
		System.out.println("login");
	}
	
	@Test(priority=1)
	public void c() {
		System.out.println("logout");
	}
	
	@Test
	public void a() {
		System.out.println("open");
	}

}
