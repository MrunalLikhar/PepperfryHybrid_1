package Scripts;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.Excel;
import Generic.HandlePopup;
import Generic.Photo;
import Generic.Property;
import POM.HomePage;
import POM.LoginPage;
import POM.PinCodeSearchPage;

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
		String t = driver.getTitle();
		
		
		Reporter.log(t, true);
		Assert.assertEquals(t, "Online Furniture Shopping Store: Shop Online in India for Furniture, Home Decor, Furnishings, Kitchenware, Hardware Products @ Pepperfry - India's Largest Home Shopping Destination");
		Photo.getphoto(driver, Screenshots, "Homepage");
		//Excel.putDataInExcel(excelpath, "Result", 1, 1, t);
		
		HomePage h = new HomePage(driver);
		h.clickonFindStudio();
		Thread.sleep(2000);
		
		
		
		PinCodeSearchPage p =new PinCodeSearchPage(driver);
		//String pc=Excel.getExcelData(excelpath, "Sheet1", 1, 2);
		p.enterPinCode("400603");
		Thread.sleep(1000);
		p.clickSearch();
		
	}
	

}
