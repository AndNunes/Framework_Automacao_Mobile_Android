package br.com.framework.pageobjects;

import org.openqa.selenium.By;

public class MenuPageObjects {

	private By menuSeuBarrigaNativo = By.xpath("//android.widget.TextView[@text='SeuBarriga Nativo']");
	
	
	
	public By getMenuSeuBarrigaNativo() {
		return menuSeuBarrigaNativo;
	}
}
