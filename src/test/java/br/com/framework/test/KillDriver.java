package br.com.framework.test;

import org.junit.Test;

import br.com.framework.utils.Driver;

public class KillDriver {

	@Test
	public void encerraDriver() {
		Driver.getDriver().quit();
	}
}
