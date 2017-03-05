package TestNGAnnotations;

import org.testng.annotations.Test;

public class ExamplePriority {

	// STCM

	@Test(priority = 4)
	public void addItems() {
		System.out.println("Add Items to Cart");
		// logical code to execute all these events
	}

	@Test(priority = 5)
	public void deleteItems() {
		System.out.println("Delete Items from Cart");
	}

	@Test(priority = 3)
	public void beforeMethod() {
		System.out.println("Launch Browser & Login");
	}

	@Test(priority = 6)
	public void afterMethod() {
		System.out.println("Close Browser");
	}

	@Test(priority = 2)
	public void beforeTest() {
		System.out.println("Fetch Data from xml");
	}

	@Test(priority = 8)
	public void afterTest() {
		System.out.println("Clears Data from the cache");
	}

	@Test(priority = 1)
	public void beforeSuite() {
		System.out.println("Create Log Files, Create objects for Reporting");
	}

	@Test(priority = 7)
	public void AfterSuite() {
		System.out.println("Close Log Files, Close objects for Reporting");
	}

}
