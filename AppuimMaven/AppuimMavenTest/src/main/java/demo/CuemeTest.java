package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

//import java.io.File;

import java.net.MalformedURLException;

import java.net.URL;

//import java.util.concurrent.TimeUnit;


public class CuemeTest {

	private static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		
		try {
			// Create object of DesiredCapabilities class

			DesiredCapabilities capabilities = new DesiredCapabilities();

			// Optional

			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

			// Specify the device name (any name)

			capabilities.setCapability("deviceName", "My New Phone");

			// Platform version

			capabilities.setCapability("platformVersion", "4.4.1");

			// platform name

			capabilities.setCapability("platformName", "Android");

			// specify the application package that we copied from appium

			//capabilities.setCapability("appPackage", "io.selendroid.directory");
			capabilities.setCapability("appPackage", "com.openstream.cueme.services.workbench");

			// specify the application activity that we copied from appium

			//capabilities.setCapability("appActivity", "EmployeeDirectory");
			capabilities.setCapability("appActivity","com.openstream.mmi.gui.CuemeActivityDelegate");
			capabilities.setCapability("appActivity","com.openstream.cueme.services.screen.WBBrowserRenderer");

			// Start android driver, default it will be 4723

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.context("WEBVIEW_com.openstream.cueme.services.workbench");
			Thread.sleep(10000);
			driver.findElementById("userId").sendKeys("sysadmin");
			driver.findElementById("CuemePassword").sendKeys("MMNext13#");
			driver.findElementById("authParam_Format").sendKeys("dc");
			driver.findElementById("authParam_DCDomain").sendKeys("Standard");
			driver.findElementById("authParam_Country").sendKeys("US");
			driver.findElementById("authParam_SiteId").sendKeys("32961");
			driver.findElementById("downloadId").click();
			
// close the application
			Thread.sleep(20000);

			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
