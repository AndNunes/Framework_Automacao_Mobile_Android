package br.com.framework.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.framework.businesspages.LoginPage;
import br.com.framework.businesspages.MenuPage;
import br.com.framework.evidencias.Evidencias;
import br.com.framework.relatorios.extentreport.GerarExtentReport;
import br.com.framework.utils.BaseTeste;
import br.com.framework.utils.Dsl;


public class RealizarOutroLoginTeste extends BaseTeste {

	MenuPage menuPage = new MenuPage();
	LoginPage loginPage = new LoginPage();
	
	@Test
	public void realizarOutroLogin() {
		
		BaseTeste.setNomeTeste("Realizar outro Login");
		
		GerarExtentReport.test = GerarExtentReport.extents.createTest(getNomeTeste(), "Execução do Teste de Realizar Login na Aplicação");
		
		Dsl.updateDriver();
		
		//Acessar Menu Seu Barriga Híbrido
		menuPage.acessarSeuBarrigaNativo();
		 
		//Realizar Login
		loginPage.realizarLogin("anderson@teste", "911209167");
		
		Dsl.esperar(3000);
		
		Evidencias.gerarScreenshot();
		Assert.assertTrue(Dsl.existeElementoPorTexto("Teste Falho"));
	}
}
