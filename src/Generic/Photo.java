package Generic;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Photo {
	public static String getphoto(WebDriver driver,String folder,String testcasename)
	{
	String path="";
		try {
		Date d=new Date();
		String date = d.toString().replace(":","-");
		  path = folder+testcasename+".png"+date;
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File(path));
		}
		catch(Exception e)
		{
		Reporter.log("Error-photo is not taken");
	}
		return path;

}
}