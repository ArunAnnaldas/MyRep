package retryAnalyzerPackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class Listener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		IRetryAnalyzer retryTestFail = annotation.getRetryAnalyzer();
		System.out.println("Value of  retryTestFail is " + retryTestFail);

		if (retryTestFail == null) {
			annotation.setRetryAnalyzer(FailedTestRetry.class);
			System.out.println("Value of  retryTestFail is " + retryTestFail);
		}

		System.out.println("I am inside IAnnotationTransformer");

	}

}
