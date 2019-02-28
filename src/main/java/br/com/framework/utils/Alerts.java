package br.com.framework.utils;

import org.openqa.selenium.By;

public class Alerts {

	public static String verificarTituloAlerta(By by) {
		return Dsl.obterTextoElemento(by);
	}
	
	public static String verificarMensagemAlerta(By by) {
		return Dsl.obterTextoElemento(by);
	}
}
