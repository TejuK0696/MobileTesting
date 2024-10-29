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

public class ScrollDemo extends ConfigureAppium{
	
	
	@Test
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException {
		
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			
				//UIAutomator method --> directly search by google engine
			//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
			
			//ScrollUtilByUIAutomator("WebView");  ///exactly know the where to scroll use this
			
		
		
		// just to scroll(no prior idea)
		ScrollByJavascript();
		
		Thread.sleep(2000);
		
		
		
	}

}
