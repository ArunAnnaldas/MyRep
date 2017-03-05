package retryAnalyzerPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class retryTest {

	int counter = 0;

	@Test
	public void Login() {
		if (counter == 0) {
			counter++;
			Assert.fail();
		} else
			Assert.assertEquals(true, true);
	}

	@AfterSuite
	public void cleanResults(ITestContext testContext) {

		List<ITestResult> testToBeRemoved = new ArrayList<>();

		int failedTestID, skippedTestID, passedTestID = 0;

		Set<Integer> passedTestIDs = new HashSet<>();
		Set<Integer> failedTestIDs = new HashSet<>();
		Set<Integer> skippedTestIDs = new HashSet<>();

		for (ITestResult passedTest : testContext.getPassedTests().getAllResults()) {
			passedTestIDs.add(getId(passedTest));
			System.out.println("PassedTest" + getId(passedTest));
		}

		for (ITestResult skippedTest : testContext.getSkippedTests().getAllResults()) {
			skippedTestIDs.add(getId(skippedTest));
			System.out.println("Skipped Test " + getId(skippedTest));
		}

		for (ITestResult failedTest : testContext.getFailedTests().getAllResults()) {
			failedTestIDs.add(getId(failedTest));
			System.out.println("Failed Test" + getId(failedTest));
		}

		for (ITestResult skippedTest : testContext.getSkippedTests().getAllResults()) {
			for (ITestResult passedTest : testContext.getPassedTests().getAllResults()) {

				skippedTestID = getId(skippedTest);
				passedTestID = getId(passedTest);

				if (skippedTestIDs.contains(passedTestID)) {
					testToBeRemoved.add(skippedTest);
				}
			}
		}

		// delete all the test that are added to testToBeRemoved

		for (Iterator<ITestResult> iterator = testContext.getSkippedTests().getAllResults().iterator(); iterator
				.hasNext();) {
			ITestResult testResult = iterator.next();
			if (testToBeRemoved.contains(testResult)) {
				iterator.remove();
			}
		}

	}

	public static int getId(ITestResult result) {
		int id = result.getTestClass().getName().hashCode();
		id = 31 * id + result.getMethod().getMethodName().hashCode();
		id = 31 * id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
		return id;
	}

}
