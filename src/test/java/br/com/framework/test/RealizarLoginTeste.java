package br.com.framework.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.framework.business.LoginPage;
import br.com.framework.business.MenuPage;
import br.com.framework.evidencias.Evidencias;
import br.com.framework.relatorios.extentreport.GerarExtentReport;
import br.com.framework.utils.BaseTeste;
import br.com.framework.utils.Dsl;

public class RealizarLoginTeste extends BaseTeste {
	
	MenuPage menuPage = new MenuPage();
	LoginPage loginPage = new LoginPage();
	
	@Test
	public void realizarLogin() {
		
		BaseTeste.setNomeTeste("Realizar Login");
		
		GerarExtentReport.test = GerarExtentReport.extents.createTest(getNomeTeste(), "Execução do Teste de Realizar Login na Aplicação");
		
		Dsl.updateDriver();
		
		//Acessar Menu Seu Barriga Híbrido
		menuPage.acessarSeuBarrigaNativo();
		 
		//Realizar Login
		loginPage.realizarLogin("anderson@teste", "911209167");
		
		Dsl.esperar(3000);
		
		Evidencias.gerarScreenshot();
		Assert.assertTrue(Dsl.existeElementoPorTexto("Conta para movimentacoes"));
		Assert.assertTrue(Dsl.existeElementoPorTexto("Conta com movimentacao"));
		Assert.assertTrue(Dsl.existeElementoPorTexto("Conta para saldo"));
		Assert.assertTrue(Dsl.existeElementoPorTexto("Conta para extrato"));
		
	}
}
