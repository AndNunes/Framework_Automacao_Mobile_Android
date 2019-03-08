package br.com.framework.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {

	private static AndroidDriver<MobileElement> driver;
	public static LeitorProerties leitorProerties;

	public static AndroidDriver<MobileElement> getDriver() {
		
		if (driver == null) {

			createDriver();
		}
		
		return driver;
	}
	
	public static void KillDriver() {
		fechaDriver();
	}
	
	private static void fechaDriver() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	public static void setUpDriver() {

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	private static void createDriver() {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability("platformName", leitorProerties.getValor("platformName"));
		desiredCapabilities.setCapability("deviceName", leitorProerties.getValor("emulator"));
		desiredCapabilities.setCapability("automationName", "uiautomator2");
//		desiredCapabilities.setCapability("appPackage", "br.gov.caixa.ecobrancamobile");
//		desiredCapabilities.setCapability("appActivity", "br.gov.caixa.ecobrancamobile.view.activities.MainActivity");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + leitorProerties.getValor("caminhoApk"));

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	public static void criaLeitorPropertie() {
		leitorProerties = new LeitorProerties();
	}

}
