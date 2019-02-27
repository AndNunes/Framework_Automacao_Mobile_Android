package br.com.framework.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {

	private static AndroidDriver<MobileElement> driver;
	public static LeitorProerties leitorProerties;
		
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			
			criaLeitorPropertie();
			createDriverAndroid();
		}
			return driver;
	}

	private static void createDriverAndroid() {
		
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		desiredCapabilities.setCapability("platformName", leitorProerties.getValor("platformName"));
		desiredCapabilities.setCapability("deviceName", leitorProerties.getValor("emulator"));
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + leitorProerties.getValor("caminhoApk"));
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void criaLeitorPropertie() {
		System.out.println("Erro na criação do Propertie");
		leitorProerties = new LeitorProerties();
	}
	

}
