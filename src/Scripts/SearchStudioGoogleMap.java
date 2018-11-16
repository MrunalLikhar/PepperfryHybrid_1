package Scripts;


import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import Generic.BaseTest;
import Generic.Excel;
import Generic.HandlePopup;
import Generic.Photo;
import Generic.Property;
import POM.DirectionsPage;
import POM.HomePage;
import POM.LoginPage;
import POM.PinCodeSearchPage;
import POM.StudioDetailsPage;
import POM.StudioGoogleMapPage;

public class SearchStudioGoogleMap extends BaseTest{
	
	
	@Test
	public void SearchStudio() throws InterruptedException{
		
		LoginPage l =new LoginPage(driver);
/*		l.notification();
		Thread.sleep(2000);*/
		l.Loginlink();
		Thread.sleep(3000);
		String EmailID =Excel.getExcelData(excelpath, "Sheet1", 1, 0);
		l.EmailIdTxtbx(EmailID);
		Thread.sleep(2000);
		String pwd=Excel.getExcelData(excelpath, "Sheet1", 1, 1);
		l.pwdtxtbx(pwd);
		Thread.sleep(2000);
		l.signInbtn();
		Thread.sleep(2000);
		
		//Excel.putDataInExcel(excelpath, "Result", 1, 1, t);
		
		HomePage h = new HomePage(driver);
		h.clickonFindStudio();
		Thread.sleep(2000);
		
		
		
		PinCodeSearchPage p =new PinCodeSearchPage(driver);
		/*String pc=Excel.getExcelData(excelpath, "Sheet1", 1, 2);
		Reporter.log(pc, true);*/
		p.enterPinCode("400603");
		Thread.sleep(1000);
		p.clickSearch();
		Thread.sleep(1000);
		p.clickStudio();
		Thread.sleep(1000);
		Photo.getphoto(driver, Screenshots, "SelectedStudioDetails");
		String title1 =driver.getTitle();
		Reporter.log(title1, true);
		
		StudioDetailsPage sdp = new StudioDetailsPage(driver);
		sdp.clickGoogleMap();
		Thread.sleep(5000);
		String mainWindow = driver.getWindowHandle();
		Set <String> windows = driver.getWindowHandles();
		for(String ele:windows) {
		driver.switchTo().window(ele);
		Thread.sleep(3000);
		}
		String title2 = driver.getTitle();
		Reporter.log(title2, true);
		Photo.getphoto(driver, Screenshots, "ViewStudioOnGoogleMaps");
		Thread.sleep(2000);
	
		
		StudioGoogleMapPage sgp = new StudioGoogleMapPage(driver);
		String address= sgp.printAddress();
		Reporter.log(address, true);
		sgp.clickdirection();
		Thread.sleep(1000);
		
		DirectionsPage dp = new DirectionsPage(driver);
		String startPoint = Excel.getExcelData(excelpath, "Sheet1", 1, 3);
		dp.enterStartingPoint(startPoint);
		Thread.sleep(1000);
		dp.clickReverse();
		Thread.sleep(1000);
		Photo.getphoto(driver, Screenshots, "Directions from start point");
		
		driver.close();
		Thread.sleep(1000);;
		driver.switchTo().window(mainWindow);
		Thread.sleep(2000);
		
		h.clickLogout(driver);
	}
	
	

	
	

}
