package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement; 
public class InvalidCredentials extends BaseClass{
	
	MobileElement emailField;
    MobileElement passwordField;
    MobileElement loginButton;

    @BeforeMethod
    public void setupElements() {
        emailField = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]"));
        passwordField = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]"));
        loginButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]"));
    
		emailField.clear();
		passwordField.clear();
    }
	
	@Test
	public void invalidEmailValidPassword() {
		try {
			Thread.sleep(1000);
			emailField.sendKeys("fakeadmin@3sdcl.com");
			passwordField.sendKeys("Password@123");
			loginButton.click();
			Thread.sleep(2000);
			String pageSource = driver.getPageSource();
			String expectedText = "Invalid Credentials";
			Assert.assertTrue(pageSource.contains(expectedText));


		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void validEmailInvalidPassword() {
		try {
			Thread.sleep(1000);
			emailField.sendKeys("admin@3sdcl.com");
			passwordField.sendKeys("Password@1234");
			loginButton.click();
			Thread.sleep(2000);
			String pageSource = driver.getPageSource();
			String expectedText = "Invalid Credentials";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void invalidEmailInvalidPassword() {
		try {
			Thread.sleep(1000);
			emailField.sendKeys("fakeadmin@3sdcl.com");
			passwordField.sendKeys("Password@1234");
			loginButton.click();
			Thread.sleep(2000);
			String pageSource = driver.getPageSource();
			String expectedText = "Invalid Credentials";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void noEmailAndPassword() {
		try {
			Thread.sleep(1000);
			loginButton.click();
			Thread.sleep(1000);
			String pageSource = driver.getPageSource();
			String expectedText = "Can not be empty";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void passwordAndNoEmail() {
		try {
			Thread.sleep(1000);
			passwordField.sendKeys("Password@123");
			loginButton.click();
			Thread.sleep(1000);
			String pageSource = driver.getPageSource();
			String expectedText = "Can not be empty";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void emailAndNoPassword() {
		try {
			Thread.sleep(1000);
			emailField.sendKeys("admin@3sdcl.com");
			loginButton.click();
			Thread.sleep(1000);
			String pageSource = driver.getPageSource();
			String expectedText = "Can not be empty";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
