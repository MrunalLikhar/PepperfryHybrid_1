package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Mousehover;

public class HomePage {
	
	@FindBy(xpath = "//span[.='Find A Studio']")
	private WebElement studio;
	
	@FindBy(xpath="//a[contains(text(),'Hi')]")
	private WebElement profileName;
	
	@FindBy(xpath="//a[.='My Profile']")
	private WebElement myProfile;
	
	@FindBy(xpath="(//a[.='Logout'])[2]")
	private WebElement logout;
	
	@FindBy(xpath="//input[@id='search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//input[@id='searchButton']")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void clickonFindStudio() {
		studio.click();
		
	}
	
	public void clickMyProfile(WebDriver driver) throws InterruptedException {
		
		Mousehover.performMouseHover(driver, profileName);
		Thread.sleep(2000);
		myProfile.click();
	}
	
	public void clickLogout(WebDriver driver) throws InterruptedException {
		Mousehover.performMouseHover(driver, profileName);
		Thread.sleep(2000);
		logout.click();
		
	}
	
	public void enterProduct(String product ) {
		searchBox.sendKeys(product);
	}
	
	public void clickSearch()
	{
		searchButton.click();
	}

}
