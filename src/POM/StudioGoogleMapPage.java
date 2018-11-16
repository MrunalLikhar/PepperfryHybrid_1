package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudioGoogleMapPage {
	
	

			@FindBy(xpath="//span[contains(text(),'Manpada')]")
			private WebElement address;
			
			@FindBy(xpath="//label[.='Directions']/../div")
			private WebElement direction;
				
			
			public StudioGoogleMapPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			public String printAddress()
			{
				String t=address.getText();
				return t;
			}
			
			public void clickdirection()
			{
				direction.click();
			}
}
