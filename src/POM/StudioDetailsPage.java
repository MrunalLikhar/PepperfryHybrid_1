package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudioDetailsPage {
	
	@FindBy(xpath="//a[.='View On Google Maps']")
	private WebElement googleMap;
	
	public StudioDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickGoogleMap()
	{
		googleMap.click();
	}

}
