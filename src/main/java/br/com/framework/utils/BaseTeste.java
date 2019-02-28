package br.com.framework.utils;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

import br.com.framework.evidencias.Evidencias;
import br.com.framework.relatorios.GerarPdf;

public class BaseTeste {
	
	public static String nomeTeste = "";
	
	@Rule
	public TestName testName = new TestName();	

	@Before
	public void inicializa() throws MalformedURLException {
		Driver.setUpDriver();
		nomeTeste = testName.getMethodName();
	}
	
	@After
	public void killDriver() {
		Driver.getDriver().resetApp();
		GerarPdf.montaPdf();
	}
	
	@AfterClass
	public static void KillDriver() {
		Evidencias.zerarEvidencias();
	}
}
