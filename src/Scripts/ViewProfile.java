package Scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.Excel;
import Generic.Photo;
import POM.HomePage;
import POM.LoginPage;

public class ViewProfile extends BaseTest {
	@Test
	public void profileDisplay() throws InterruptedException{
		
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
		
		
		HomePage h = new HomePage(driver);
		h.clickMyProfile(driver);
		Thread.sleep(2000);
		String t = driver.getTitle();
		Reporter.log(t, true);
		Photo.getphoto(driver, Screenshots, "ProfileInfo");
		
		h.clickLogout(driver);
	}

}
