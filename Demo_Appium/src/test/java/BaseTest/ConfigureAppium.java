package BaseTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import Base.AppiumServer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ConfigureAppium {
	
	public AndroidDriver driver;
	
	
	@BeforeClass
public void AppiumConfig() throws MalformedURLException, URISyntaxException {
		
	
		AppiumServer.start();
		
		//To set the device 
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("DemoPixel9");
		options.setApp("//Users//apple//Eclipse_Appium//Demo_Appium//src//test//java//resource//ApiDemos-debug.apk");
		
		//To set Driver
		 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void LongPressGestureAction(WebElement eletext) {
		
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement) eletext).getId(),
						"duration", 2000));
	}
	
	//exact to scroll the value
	public void ScrollUtilByUIAutomator(String visibleText) {

	    // Method to scroll into view by text
	        driver.findElement(AppiumBy.androidUIAutomator(
	                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + visibleText + "\"));"));
	    
	}
	//No idea till where to scroll adding dowhile loop to end of the scroll element
	public void ScrollByJavascript() {
		
		boolean canScrollMore;
		
		do {
		 canScrollMore = (Boolean) 
				((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 1.0
		));
		 
		}
		while(canScrollMore);
	}

	public void SwipeAction(WebElement element, String direction, double valueinpercentage) {
		

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) element).getId(),
				
			    "direction", direction,
			    "percent", valueinpercentage
			));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		AppiumServer.stop();
	
	}

	
}
