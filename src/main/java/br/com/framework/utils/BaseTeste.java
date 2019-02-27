package br.com.framework.utils;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import br.com.framework.relatorios.GerarPdf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTeste {

	private static AndroidDriver<MobileElement> driver = Driver.getDriver();
	
	public static String nomeTeste = "";
	
	@Rule
	public TestName testName = new TestName();
	
	
	@Before
	public void setUp() throws MalformedURLException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		nomeTeste = testName.getMethodName();
	}
	
	@AfterClass
	public static void killDriver() {
		GerarPdf.montaPdf();
		driver.quit();
	}
	
	@After
	public void resetApp() {
		
		driver.resetApp();
	}
}
