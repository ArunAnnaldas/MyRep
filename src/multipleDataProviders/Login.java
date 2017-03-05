package multipleDataProviders;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice
public class Login {

	@Test(dataProvider = "DataRepository", dataProviderClass = DataProviderHub.class)
	public void testLogin(String UserName, String Password) {

		System.out.println("Login Tested successfully with UserName : " + UserName + " & Password : " + Password
				+ " with thread id : " + Thread.currentThread().getId());

	}

}
