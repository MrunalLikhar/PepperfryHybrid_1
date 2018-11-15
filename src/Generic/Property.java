package Generic;

import java.io.FileInputStream;
import java.util.Properties;

public class Property {
	
	public static String getPropertyData(String filepath, String key) {
		String s="";
		
		Properties p= new Properties();
		try {
			p.load(new FileInputStream(filepath));
			 s=p.getProperty(key);
			
		} 
		catch (Exception e) {
			
		}
		return s;
		
		
		
	}
	

}
