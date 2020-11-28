package userDefinedLibraries;
/**
 * This class is defined in order to setup different Webdrivers.
 * 
 * @author BINARYBEASTS
 * @since 2020/11/27
 * 
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverSetup {
	public static WebDriver driver;
	public static String exePath;
	public static String url = "https://www.urbanladder.com/";
	public static String browsertype;
	
	public static WebDriver driverInstantiate(String browser) {
		
		// Declaration and instantiation of objects/variables
		browsertype= browser;
		if(browsertype.equalsIgnoreCase("chrome")) {
			
			exePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();				        	        
	    }
		else if(browser.equalsIgnoreCase("opera")) {
			
			exePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\operadriver.exe";
			System.setProperty("webdriver.opera.driver", exePath);
			driver = new OperaDriver();				        	        
	    }  
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Launch browsers and direct it to the Base URL
		driver.get(url);
		driver.manage().deleteAllCookies();
		return driver;	  
	}	
	
	public static void driverClose() {
		
		DriverSetup.driver.close();	   
	  
	}
}
