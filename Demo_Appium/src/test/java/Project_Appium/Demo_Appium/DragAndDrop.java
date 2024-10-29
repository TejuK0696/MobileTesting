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

public class DragAndDrop extends ConfigureAppium{
	
	
	@Test
	public void DragDropTest() throws MalformedURLException, InterruptedException {
		
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
			
			WebElement sourcElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
			
			//code for drag and drop take coordianate from appoum track inspectoe
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) sourcElement).getId(),
				    "endX", 625,
				    "endY", 627
				));
			String resultString =	driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
			Assert.assertEquals(resultString, "Dropped!");
			
		
		Thread.sleep(2000);
		
		
		
	}

}
