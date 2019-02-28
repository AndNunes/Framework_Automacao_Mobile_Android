package br.com.framework.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	RealizarLoginTeste.class,
	RealizarOutroLoginTeste.class,
	KillDriver.class
})

public class ExecGeral {

	
}
