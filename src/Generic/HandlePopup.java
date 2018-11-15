package Generic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class HandlePopup implements Constant {
	
/*	public static void handleNotification(WebDriver driver) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty(key, value);
		driver =new ChromeDriver(options);
		driver.get("https://www.pepperfry.com/studio-pepperfry.html");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
	}*/
	public static void closePopup(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		String t = a.getText();
		Reporter.log(t, true);
		a.dismiss();
		
	}

}
