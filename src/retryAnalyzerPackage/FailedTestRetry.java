package retryAnalyzerPackage;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailedTestRetry implements IRetryAnalyzer {

	private int retryCount = 2;
	private int initialCount = 0;

	@Override
	public boolean retry(ITestResult result) {

		if (initialCount < retryCount) {
			initialCount++;
			return true;
		} else
			return false;
	}

}
