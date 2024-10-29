package Project_Appium.Demo_Appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import BaseTest.ConfigureAppium;
import io.appium.java_client.AppiumBy;

public class LongPress extends ConfigureAppium{
	
	
	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException {
		
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
			driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
			
			//documentation in git gesture 
			
			WebElement eletext = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
			LongPressGestureAction(eletext);
						
			
		String menuText = driver.findElement(By.id("android:id/title")).getText(); //to get the value
		Assert.assertEquals(menuText, "Sample menu");
		
		 driver.findElement(By.id("android:id/title")).isDisplayed(); //only to display
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed()); //asert true i.e it has to be true value or else test would be fail
		

		
		
		
	}

}
