package BeforeTest_BeforeClass;

import org.testng.annotations.Test;

@Test(enabled = false)
public class Class1 extends TestingBeforeClassAndBeforeTest {

	@Test(threadPoolSize = 2, invocationCount = 6, invocationTimeOut = 10000)
	public void Method1() throws InterruptedException {
		System.out.println("Inside Method 1 with thread id as " + Thread.currentThread().getId());

		for (int i = 1; i <= 2; i++) {
			Thread.sleep(1000);
			System.out.println("Waiting for Timeout");
		}

	}
	/*
	 * @Test(enabled = false) public void Method2() { if (true) { throw new
	 * SkipException("Skipping this test case"); } System.out.println(
	 * "Inside Method 2"); // coding is in progress }
	 */
}
