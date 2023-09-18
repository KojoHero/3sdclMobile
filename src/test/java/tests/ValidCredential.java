package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class ValidCredential extends BaseClass{
	MobileElement emailField;
    MobileElement passwordField;
    
	@BeforeMethod
	public void setupElements() {
        emailField = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]"));
        passwordField = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]"));
       
		emailField.clear();
		passwordField.clear();
    }
	
	@Test
	public void correctCredentials() {
		try {
			Thread.sleep(1000);
			emailField.sendKeys("admin@3sdcl.com");
			passwordField.sendKeys("Password@123");
	        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]")).click();

			Thread.sleep(5000);
			String pageSource = driver.getPageSource();
			String expectedText = "HOME SCREEN";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
