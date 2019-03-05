package br.com.framework.relatorios.extentreport;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import br.com.framework.utils.Driver;

public class GerarExtentReport {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extents;
	public static ExtentTest test;

	public static ExtentTest getTest() {
		return test;
	}

	public static ExtentReports getExtents() {
		return extents;
	}

	public static void startReporter() {
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(Driver.leitorProerties.getValor("caminhoRelatorioExtentReport"));
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + Driver.leitorProerties.getValor("caminhoRelatorioExtentReport"));
		extents = new ExtentReports();
		extents.attachReporter(htmlReporter);

		setSystemInfo();
		setConfigReporter();
	}

	/**
	 * 
	 * Definindo informações que serão apresentadas no Reporter
	 * 
	 */
	private static void setSystemInfo() {

		extents.setSystemInfo("Sistema Operacional: ", "Windows 10");
		extents.setSystemInfo("Plataforma de Teste: ", Driver.leitorProerties.getValor("platformName"));
		extents.setSystemInfo("Testador por: ", System.getProperty("user.home"));
	}

	/**
	 * Definindo o título do documento Definindo o nome do documento Definindo a
	 * localização do gráfico do relatório Definindo tema do Relatório
	 * 
	 **/
	private static void setConfigReporter() {

		htmlReporter.config().setDocumentTitle("Relatório de Execução de Testes Regrssivos");
		htmlReporter.config().setReportName("Fóton Informática");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss a");
		htmlReporter.config().setEncoding("ISO-8859-1");
	}

	public static void setResults(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			GerarExtentReport.test.log(Status.FAIL, MarkupHelper
					.createLabel(result.getName() + " Test Case FAILED due to below issues", ExtentColor.RED));
			GerarExtentReport.test.fail(result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			GerarExtentReport.test.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test case PASS", ExtentColor.GREEN));
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			GerarExtentReport.test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test case SKIP", ExtentColor.BLUE));
		}
	}

}
