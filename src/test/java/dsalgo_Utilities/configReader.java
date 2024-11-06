package dsalgo_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	
//	private Properties prop;
//	
//	public String getProperties(String key) {
//		return prop.getProperty(key);
//	}
//	
//	public configReader () {
//		prop = new Properties();
//		try {
//			FileInputStream ip = new FileInputStream ("./src/test/resources/Config/Config.properties");
//		    try {
//				prop.load(ip);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
private static Properties prop = null;

	
	public static String getProperty(String key) {
		
		if ( prop == null ) intializeProperties();		
		return prop.getProperty(key);
		
	}

	public static Properties intializeProperties() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/Config/Config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	//
	public static String registerPageUrl() {
		
		String url=prop.getProperty("registerUrl");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("url not specified");
		
	}


}
