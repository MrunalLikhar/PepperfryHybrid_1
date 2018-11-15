package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mousehover {
	
	public static void performMouseHover(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform(); 
	}
}
