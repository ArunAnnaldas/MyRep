package multipleDataProviders;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice
public class Login {

	@Test(dataProvider = "DataRepository", dataProviderClass = DataProviderHub.class)
	public void testLogin(String UserName, String Password) throws InterruptedException {

		System.out.println("Login Tested successfully with UserName : " + UserName + " & Password : " + Password
				+ " with thread id : " + Thread.currentThread().getId());
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://www.facebook.com/");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		String url = driver.getCurrentUrl();
		//String PageSource = driver.getPageSource();
		System.out.println("Url is : " + url);
		//System.out.println("Source is " + PageSource);
		System.out.println(driver.getWindowHandle());
		driver.quit();

	}

}
