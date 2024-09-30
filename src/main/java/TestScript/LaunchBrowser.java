package TestScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchBrowser {
	WebDriver driver;
	AppiumDriver AppDriver;
	public void Browser() throws InterruptedException, IOException {
		
		FileReader reader=new FileReader("./src/main/resources/config.proprties");
		Properties pro=new Properties();
		pro.load(reader);
		
		String BrowserName=pro.getProperty("Browser");
		String URL=pro.getProperty("URL");
		String AutomationName=pro.getProperty("AutomationName");
		String DeviceName=pro.getProperty("DeviceName");
		

		if(AutomationName.equalsIgnoreCase("WebAutomation")) {
		if(BrowserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox")){
			 driver=new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("safari")){
			 driver=new SafariDriver();
		}
		driver.get(URL);
		Thread.sleep(5000);
		
		}else if(AutomationName.equalsIgnoreCase("MobileAutomation")) {
			
			if(DeviceName.equalsIgnoreCase("Android")) {
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, 14.0);
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
				cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\User\\Downloads\\BitBarSampleApp.apk");
//				URL url=new URL("http://localhost:4723/wd/hub");
				URL url=new URL("http://127.0.0.1:4723/wd/hub");
				System.out.println("URL");
				AppDriver=new AndroidDriver(url,cap);
				System.out.println("Cap");
	
				
			}else if(DeviceName.equalsIgnoreCase("IOS")) {
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iOS");
				cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "");
				AppDriver=new IOSDriver(new java.net.URL("https://localhost:4723/wd/hub"),cap);
			}
		}
	}
	
	
}


