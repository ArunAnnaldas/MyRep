package multipleDataProviders;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;



@Guice
public class Login{

	
	
	@Test(dataProvider = "DataRepository", dataProviderClass = DataProviderHub.class)
	public void testLogin(String UserName, String Password) throws InterruptedException, MalformedURLException {

		WebDriver driver;
		
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, "Firefox");
        caps.setCapability(CapabilityType.VERSION, "45");
        caps.setCapability(CapabilityType.PLATFORM, "Windows 10");
        //caps.SetCapability("deviceName", deviceName);
        //caps.SetCapability("deviceOrientation", deviceOrientation);
        caps.setCapability("username", System.getenv("SAUCE_USERNAME"));//"SAUCE_USERNAME");
        caps.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));//"SAUCE_ACCESS_KEY");
        caps.setCapability("name", "Login");

        URL commandExecutorUri = new URL("<http://ondemand.saucelabs.com/wd/hub>");
        
        driver = new RemoteWebDriver(commandExecutorUri,caps);
		
		System.out.println("Login Tested successfully with UserName : " + UserName + " & Password : " + Password
				+ " with thread id : " + Thread.currentThread().getId());
		
		//WebDriver driver = new FirefoxDriver();
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
