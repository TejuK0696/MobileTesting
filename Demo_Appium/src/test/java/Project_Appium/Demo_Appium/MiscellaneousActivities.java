package Project_Appium.Demo_Appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import BaseTest.ConfigureAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousActivities extends ConfigureAppium{
	
	
	@Test
	public void MiscellaneousActions() throws MalformedURLException, URISyntaxException {
		
		//app package and app activity --> we can go direct to the page where the testing part is there...
		//     adb shell dumpsys window | grep -E 'mCurrentFocus|mFocusedApp' -- Mac
		//     adb shell dumpsys window | findstr "mCurrentFocus mFocusedApp" -- Windows
		// https://github.com/appium/appium-uiautomator2-driver   --> link for docs 

		Activity activity = new Activity("io.appium.android", "io.appium.android.apis.preference.PreferenceDependencies");
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", 
				ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		
		
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement wifiCheckboxelement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/checkbox")));
		wifiCheckboxelement.click();
		
		//To rotate the screen from 90 degree
		
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(200));
		WebElement wifiSettingelement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")));
		wifiSettingelement.click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		//copy past 
		//copy from clipboard - paste
		driver.setClipboardText("Demo Wifi");
		
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		
		//Presskey direct mobile buttons like back, home, enter etc.
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	
		
		
	}
	@AfterMethod
	public void resetOrientation() {
		// Set orientation back to portrait mode at the end of the test
		driver.rotate(new DeviceRotation(0, 0, 0));
	}

}
