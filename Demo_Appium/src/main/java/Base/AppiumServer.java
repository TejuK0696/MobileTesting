package Base;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {
	
	static AppiumDriverLocalService server;
	
	
	
	static void setInstance() {
		
		//Run Configuration -> Environment and set the Android_Home or this method will also work 
		
		Map<String, String> environment = new HashMap<>(System.getenv());
		environment.put("ANDROID_HOME", "/Users/apple/Library/Android/sdk");
		environment.put("ANDROID_SDK_ROOT", "/Users/apple/Library/Android/sdk");
		

		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.usingDriverExecutable(new File("/usr/local/bin/node"))
				.withEnvironment(environment)
				.usingPort(4723)
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
				.withLogFile(new File("Appiumlog.txt"))
				.withIPAddress("127.0.0.1");
		server = AppiumDriverLocalService.buildService(builder);

		
	
	}
	
	static AppiumDriverLocalService getInstance() {
		if(server == null) {
			setInstance();
		}
		return server;
	}
	
	public static void start() {
		getInstance().start();
		System.out.println(server.getUrl());
		System.out.println(server.isRunning());
		System.out.println("Appium Server STARTED");
	}
	
	public static void stop() {
		if(server != null) {
			getInstance().stop();
			System.out.println("Appium Server STOPPED");
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		AppiumServer.start();
		Thread.sleep(2000);
		AppiumServer.stop();
	}
	

}
