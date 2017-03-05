package BeforeTest_BeforeClass;

import org.testng.annotations.Test;

public class Class2 extends TestingBeforeClassAndBeforeTest {

	@Test
	public void Method3() {
		System.out.println("Inside Method 3");
	}

	@Test
	public void Method4() {
		System.out.println("Inside Method 4");
	}

}
