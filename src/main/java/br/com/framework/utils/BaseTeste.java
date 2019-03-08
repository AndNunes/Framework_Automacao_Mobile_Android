package br.com.framework.utils;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import br.com.framework.evidencias.Evidencias;
import br.com.framework.relatorios.GerarPdf;
import br.com.framework.relatorios.extentreport.GerarExtentReport;

public class BaseTeste {
	
	private static String nomeTeste = "";
	
	public static String getNomeTeste() {
		return nomeTeste;
	}
	
	public static void setNomeTeste(String nome) {
		nomeTeste = nome;
	}
		
	@BeforeTest
	public void setUpTest() {
	
		Driver.criaLeitorPropertie();
		GerarExtentReport.startReporter();
	}
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
	
		Driver.setUpDriver();
		Evidencias.zerarEvidencias();
	}
		
	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		
		GerarPdf.montaPdf();
		Driver.getDriver().resetApp();
	}
	
	@AfterSuite(alwaysRun = true)
	public void executaFimSuite() throws Throwable {
		
		Driver.KillDriver();
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
	
		GerarExtentReport.setResults(result);
	}
	
	@AfterTest
	public void tearDown() {
	
		GerarExtentReport.extents.flush();
	}
}
