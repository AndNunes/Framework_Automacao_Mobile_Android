package br.com.framework.business;

import br.com.framework.evidencias.Evidencias;
import br.com.framework.pageobjects.MenuPageObjects;
import br.com.framework.utils.Dsl;

public class MenuPage {

	MenuPageObjects pageObjects;
	
	public MenuPage() {
		pageObjects = new MenuPageObjects();
	}
	
	public void acessarSeuBarrigaNativo() {
		Dsl.waitVisible(pageObjects.getMenuSeuBarrigaNativo());
		Evidencias.gerarScreenshot();
		Dsl.clicar(pageObjects.getMenuSeuBarrigaNativo());
	}
}
