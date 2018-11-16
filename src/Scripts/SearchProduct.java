package Scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import Generic.BaseTest;
import Generic.Excel;
import Generic.Photo;
import POM.HomePage;
import POM.LoginPage;

public class SearchProduct extends BaseTest {
	
	@Test
	public void searchingProduct() throws InterruptedException{
		
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
		String pro = Excel.getExcelData(excelpath, "Sheet1", 1, 4);
		h.enterProduct(pro);
		Thread.sleep(1000);
		h.clickSearch();
		Thread.sleep(2000);
		Photo.getphoto(driver, Screenshots, "SearchedProducts");
		
		
		h.clickLogout(driver);
	}
}
