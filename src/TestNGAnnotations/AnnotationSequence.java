package TestNGAnnotations;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AnnotationSequence {

	// STCM

	@Parameters({ "Product Name", "Color", "Product Code", "Make" })
	@Test
	public void f(@Optional("Sony PS4") String name, @Optional("black") String color, @Optional("AX-400") String code,
			@Optional("2015") String make) {
		System.out.println(
				"Product " + name + " is added to Cart" + " with thread id : " + Thread.currentThread().getId());
		System.out.println(color + " with thread id : " + Thread.currentThread().getId());
		System.out.println(code + " with thread id : " + Thread.currentThread().getId());
		System.out.println(make + " with thread id : " + Thread.currentThread().getId());
		// logical code to execute all these events
	}

	@Test
	public void f1() throws Exception {
		throw new Exception("This is custom exception message");
		// System.out.println("Delete Items from Cart" + " with thread id : " +
		// Thread.currentThread().getId());
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Launch Browser & Login" + " with thread id : " + Thread.currentThread().getId());
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Close Browser" + " with thread id : " + Thread.currentThread().getId());
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Fetch Data from xml" + " with thread id : " + Thread.currentThread().getId());
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Clears Data from the cache" + " with thread id : " + Thread.currentThread().getId());
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Create Log Files, Create objects for Reporting" + " with thread id : "
				+ Thread.currentThread().getId());
	}

	@AfterSuite
	public void AfterSuite() {
		System.out.println(
				"Close Log Files, Close objects for Reporting" + " with thread id : " + Thread.currentThread().getId());
	}

	@Parameters({ "Product Name" })
	@Test
	public void testingParameters(@Optional("DefaultProduct") String ItemName) {
		throw new SkipException("This is custom Skip exception message");
		// System.out.println("The Product Name is : " + ItemName + " with
		// thread id : " + Thread.currentThread().getId());
	}

}
