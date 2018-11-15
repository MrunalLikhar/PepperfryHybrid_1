package Generic;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Generic.Photo;

public class BaseTest implements Constant{
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void launchApp() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty(key, value);
		driver = new ChromeDriver(options);
		driver.get(Property.getPropertyData(propertyFilePath, "url"));
		Thread.sleep(2000);
		/*driver.manage().deleteAllCookies();
		Thread.sleep(2000);*/
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void cloaseapp(ITestResult r)
	{
		String name = r.getName();
		int status = r.getStatus();
		if(status==2)
		{
			Photo.getphoto(driver,failedTCsPhoto,name);
		}
		
		if(status==1)
		{
			Photo.getphoto(driver,passedTCsPhoto,name);
			
		}
		
		//driver.close();
	}
	

}
