package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	static AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() {
		try {
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S21 FE 5G");
			caps.setCapability(MobileCapabilityType.UDID, "R5CRC2405JM");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability("appPackage", "com.threesdcl.eadapploginspa");
			caps.setCapability("appActivity", "com.threesdcl.eadapploginspa.MainActivity");

			URL url = new URL("http://127.0.0.1:4723/wd/hub/");
			driver = new AppiumDriver<MobileElement>(url, caps);
			Thread.sleep(2000);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}
