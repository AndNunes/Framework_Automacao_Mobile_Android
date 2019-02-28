package br.com.framework.test;

import org.junit.Test;

import br.com.framework.businesspages.LoginPage;
import br.com.framework.businesspages.MenuPage;
import br.com.framework.utils.BaseTeste;

public class RealizarLoginTeste extends BaseTeste {
	
	MenuPage menuPage = new MenuPage();
	LoginPage loginPage = new LoginPage();
	
	@Test
	public void realizarLogin() {
		
		//Acessar Menu Seu Barriga Híbrido
		menuPage.acessarSeuBarrigaNativo();
		 
		//Realizar Login
		loginPage.realizarLogin("anderson@teste", "911209167");
		
	}
}
