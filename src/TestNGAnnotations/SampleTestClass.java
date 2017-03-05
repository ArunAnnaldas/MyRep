package TestNGAnnotations;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTestClass {
	// Ctrl + Shift + o
	@Test // method which is my test case
	public void sampleTest1()
	{
		System.out.println("This is TestNG annotation 1");
	}
	
	@Test
	public void sampleTest2() throws Exception
	{
		System.out.println("This is TestNG annotation 2");
		throw new Exception("Failure");
	}
	
	@Test
	public void sampleTest3() throws Exception
	{
		System.out.println("This is TestNG annotation 3");
		throw new SkipException("Skipping this test case");
	}
	
/*	@BeforeTest
	public void sampleTest2()
	{
		System.out.println("This is TestNG annotation 2");
	}
	
	@AfterTest
	public void sampleTest3()
	{
		System.out.println("This is TestNG annotation 3");
	}
	
	@Test
	public void sampleTest4()
	{
		System.out.println("This is TestNG annotation 4");
	}
@BeforeSuite
@AfterSuite
@BeforeClass
@AfterClass
@BeforeTest
@AfterTest
@BeforeMethod
@AfterMethod
@BeforeGroups
@AfterGroups
@DataProvider
@Test
@Factory
@Listeners
@Parameters


*/	

	
	
}
