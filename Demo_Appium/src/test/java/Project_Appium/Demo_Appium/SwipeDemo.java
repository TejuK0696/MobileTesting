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

public class SwipeDemo extends ConfigureAppium{
	
	
	@Test
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException {
		
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
			driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
			
			WebElement firstImagElement = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
			//to get the first image
			Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
			 
			//to swipe
			//got code from git
//			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//				    "left", 100, "top", 100, "width", 200, "height", 200,
//				    "direction", "left",
//				    "percent", 0.75
//				));
//			
			
	
			
			SwipeAction(firstImagElement,"left", 0.25);
			
			Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),"false");

		
		Thread.sleep(2000);
		
		
		
	}

}
