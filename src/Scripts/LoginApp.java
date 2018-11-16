package Scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.Excel;
import Generic.Photo;
import POM.HomePage;
import POM.LoginPage;

public class LoginApp extends BaseTest{
	
	@Test
	public void LoginUser() throws InterruptedException{
	LoginPage l =new LoginPage(driver);
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
	
	HomePage h = new HomePage(driver);
	h.clickLogout(driver);
	
	}

}
