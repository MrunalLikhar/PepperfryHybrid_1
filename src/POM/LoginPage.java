package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//button[@id='wzrk-cancel']")
	private WebElement notification;
	
	@FindBy(xpath="//b[.='Login']")
	private WebElement login;
	
	@FindBy(xpath = "(//input[@name ='user[new]'])[1]")
	private WebElement EmailId;
	
	@FindBy(xpath = "(//input[@name ='password'])[1]")
	private WebElement pwd;
	
	@FindBy(xpath="(//input[@name ='logSubmit'])[1]")
	private WebElement SignIn;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void notification()
	{
		notification.click();
	}
	public void Loginlink() {
		login.click();
	
	}

	public void EmailIdTxtbx(String EmailID) {
		EmailId.sendKeys(EmailID);
	}
	
	public void pwdtxtbx(String password) {
		pwd.sendKeys(password);
	}
	
	public void signInbtn() {
		SignIn.click();
	}
	
	

}
