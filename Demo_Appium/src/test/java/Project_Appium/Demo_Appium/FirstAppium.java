package Project_Appium.Demo_Appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTest.ConfigureAppium;
import io.appium.java_client.AppiumBy;

public class FirstAppium extends ConfigureAppium{
	
	
	@Test
	public void WifiSettingName() throws MalformedURLException, URISyntaxException {
		
//		AppiumConfig(); --> this method is extended and it has used as before class method same as teardown() as afterclass

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		//driver.findElement(By.id("android:id/checkbox")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement wifiCheckboxelement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/checkbox")));
		wifiCheckboxelement.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(200));
		WebElement wifiSettingelement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")));
		wifiSettingelement.click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Demo Wifi");
		driver.findElement(By.id("android:id/button1")).click();
	
		
		
	}

}
