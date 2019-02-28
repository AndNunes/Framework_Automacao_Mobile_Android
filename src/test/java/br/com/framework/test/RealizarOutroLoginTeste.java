package br.com.framework.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import br.com.framework.businesspages.LoginPage;
import br.com.framework.businesspages.MenuPage;
import br.com.framework.utils.BaseTeste;
import br.com.framework.utils.Driver;

public class RealizarOutroLoginTeste extends BaseTeste {

	MenuPage menuPage = new MenuPage();
	LoginPage loginPage = new LoginPage();
	
	@Before
	public void inicializa() throws MalformedURLException {
		Driver.setUpDriver();
		nomeTeste = testName.getMethodName();
	}
	
	@Test
	public void realizarOutroLogin() {
		
		//Acessar Menu Seu Barriga Híbrido
		menuPage.acessarSeuBarrigaNativo();
		 
		//Realizar Login
		loginPage.realizarLogin("anderson@teste", "911209167");
		
	}
}
