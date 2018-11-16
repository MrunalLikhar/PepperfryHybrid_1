package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectionsPage {
	@FindBy(xpath="//div[@id='directions-searchbox-0']/div/div/input")
	private WebElement startLoc;
	
	@FindBy(xpath="//div[@class='widget-directions-icon reverse']")
	private WebElement reverseIcon;
	
	public  DirectionsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterStartingPoint(String name){
		startLoc.sendKeys(name);
		
	}
	
	public void clickReverse() {
		reverseIcon.click();
	}
}
