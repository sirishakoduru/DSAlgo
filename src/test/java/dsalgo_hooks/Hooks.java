package dsalgo_hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import dsalgo_DriverFactory.DriverFactory;
import dsalgo_Utilities.LoggerLoad;
import dsalgo_Utilities.configReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	
	public static WebDriver driver;
	//Properties prop;

	@Before
	public void setup() {
		DriverFactory.initializeBrowser(configReader.getProperty("browser"));
		driver = DriverFactory.getDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
    @After
	public void tearDown(Scenario scenario) throws InterruptedException {
		LoggerLoad.error("Scenario is Failed and taking Screenshot");
		String scenarioName=scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed()) {
			byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", scenarioName);
			
			 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        try {
		            FileUtils.copyFile(screenshot, new File("target/screenshots/" + scenario.getName() + ".png"));
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		}
		
		
		
		
		Thread.sleep(3000);
		driver.quit();
//
	}
//    @AfterAll
//	public static void tearDown() {
//		// Quit WebDriver after the last scenario
//		DriverFactory.quitDriver();
//	}

//	public static void setBrowser(String browser) {
//		Hooks.browser = browser;
//		
//	}

  
}
