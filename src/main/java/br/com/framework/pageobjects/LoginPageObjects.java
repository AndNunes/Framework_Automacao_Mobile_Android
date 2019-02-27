package br.com.framework.pageobjects;

import org.openqa.selenium.By;

public class LoginPageObjects {

	private By txtNomeLogin = By.xpath("//android.widget.EditText[@text='Nome']");
	
	private By txtSenhaLogin = By.xpath("//android.widget.EditText[@text='Senha']");
	
	private By btnEntrar = By.xpath("//android.widget.TextView[@text='ENTRAR']");
	
	public By getTxtNomeLogin() {
		return txtNomeLogin;
	}
	
	public By getTxtSenhaLogin() {
		return txtSenhaLogin;
	}
	
	public By getBtnEntrar() {
		return btnEntrar;
	}
}
