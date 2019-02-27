package br.com.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LeitorProerties {

	private Properties props;
	private static FileInputStream file;

	public LeitorProerties() {
		
		props = new Properties();
		defineCaminhoProperties();
		
		try {
			props.load(file);
		} catch (IOException e) {
			System.out.println("Deu Erro no Load >>>>> ");
			e.printStackTrace();
		}
	}
	
	
	private static void defineCaminhoProperties() {
		
		
		try {
			
			file = new FileInputStream(System.getProperty("user.dir") + "\\resource\\Configuration.properties");
			
		} catch (FileNotFoundException e) {
			new RuntimeException("Caminho do Arquivo não encotrado!");
		}
	}
	
	public String getValor(String chave) {
		 return props.getProperty(chave);
	}
}
