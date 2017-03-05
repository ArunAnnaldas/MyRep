package TestNGAnnotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Groups {

	// STCM

	@Test(groups = { "AddItems" })
	public void addItems() {
		System.out.println("Add Items to Cart");
		// logical code to execute all these events
	}

	@Test(groups = { "DeleteItems" })
	public void deleteItems() {
		System.out.println("Delete Items from Cart");
	}

	@BeforeMethod(groups = { "AddItems", "DeleteItems" })
	public void beforeMethod() {
		System.out.println("Launch Browser & Login");
	}

	@AfterMethod(groups = { "AddItems", "DeleteItems", "teardown" })
	public void afterMethod() {
		System.out.println("Close Browser");
	}

	@BeforeTest(groups = { "AddItems", "DeleteItems", "DataPrep" })
	public void beforeTest() {
		System.out.println("Fetch Data from xml");
	}

	@AfterTest(groups = { "AddItems", "DeleteItems", "teardown" })
	public void afterTest() {
		System.out.println("Clears Data from the cache");
	}

	@BeforeSuite(groups = { "AddItems", "DeleteItems", "DataPrep" })
	public void beforeSuite() {
		System.out.println("Create Log Files, Create objects for Reporting");
	}

	@AfterSuite(groups = { "AddItems", "DeleteItems" })
	public void AfterSuite() {
		System.out.println("Close Log Files, Close objects for Reporting");
	}

	@AfterTest(groups = { "Email" })
	public void openGmail() {
		System.out.println("Opening gmail");
	}

	@AfterTest(groups = { "Email" }, dependsOnMethods = { "openGmail" })
	public void composeEmail() {
		System.out.println("Compose email");
	}

	@AfterTest(groups = { "Email" }, dependsOnMethods = { "composeEmail" })
	public void sendEmail() {
		System.out.println("Sending Email");
	}

}
