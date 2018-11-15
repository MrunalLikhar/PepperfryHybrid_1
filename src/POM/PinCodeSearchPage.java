package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinCodeSearchPage {
	
	@FindBy(xpath="//input[@id='studioPinInput']")
	private WebElement pinCode;
	
	@ FindBy(xpath="//a[.='Search']")
	private WebElement search;
	
	
	public PinCodeSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterPinCode(String pin) {
		
		pinCode.sendKeys(pin);
	}
	public void clickSearch()
	{
		search.click();
	}
}
