package br.com.framework.business;

import br.com.framework.evidencias.Evidencias;
import br.com.framework.pageobjects.LoginPageObjects;
import br.com.framework.utils.Dsl;

public class LoginPage {

	private LoginPageObjects page;

	public LoginPage() {
		page = new LoginPageObjects();
	}

	public void digitarUsuario(String usuario) {
		// Informando o usuário para Login
		Dsl.waitVisible(page.getTxtNomeLogin());
		Dsl.escrever(page.getTxtNomeLogin(), usuario);
		Evidencias.gerarScreenshot();
	}

	public void digitarSenha(String senha) {

		// Informando a senha para Login
		Dsl.waitVisible(page.getTxtSenhaLogin());
		Dsl.escrever(page.getTxtSenhaLogin(), senha);
		Evidencias.gerarScreenshot();
	}
	
	public void clicarEntrar() {
		Dsl.waitVisible(page.getBtnEntrar());
		Dsl.clicar(page.getBtnEntrar());
	}
	
	
	public void realizarLogin(String usuario, String senha) {
		digitarUsuario(usuario);
		digitarSenha(senha);
		clicarEntrar();
	}
	
}
