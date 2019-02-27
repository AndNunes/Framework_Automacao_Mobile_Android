package br.com.framework.evidencias;

import static br.com.framework.utils.Driver.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.framework.utils.BaseTeste;

public class Evidencias {
	
	private static int numeroEvidencia = 0;
	
	public static void gerarScreenshot() {

		File imagem = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem, new File("evidencias/" + BaseTeste.nomeTeste + "/EV_"+ ++numeroEvidencia +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getNumeroEvidencias() {
		return numeroEvidencia;
	}
}
