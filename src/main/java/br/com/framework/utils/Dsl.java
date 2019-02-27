package br.com.framework.utils;

import static br.com.framework.utils.Driver.getDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class Dsl {

	/* ---------------- Métodos para Click ---------------- */
	
	public static void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public static void clickLongo(By by) {
		new TouchAction(getDriver()).longPress(getDriver().findElement(by)).perform();
	}

	public static void clicarEmCoordenadas(By by) {

		MobileElement element = getDriver().findElement(by);

		int x = element.getLocation().x;
		int y = element.getLocation().y / 2;

		new TouchAction(getDriver()).press(x, y).release().perform();

	}

	public static void clicaPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
	}
	
	/* ------------------- Métodos para escrita ------------------ */

	public static void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	/* ------------------ Métodos para Combos ----------------- */
	
	public static void selecionaComboPorTexto(By by, String texto) {

		getDriver().findElement(by).click();
		clicaPorTexto(texto);
	}

	public static boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).isSelected();
	}

	public static String obterTextoElemento(By by) {
		return getDriver().findElement(by).getAttribute("text");
	}

	public static void waitVisible(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static boolean existeElementoPorTexto(String texto) {

		java.util.List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		System.out.println(elements.size());
		return elements.size() > 0;
	}

	public static void aguardarElementoSumir(By by) {

		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public static void esperar(long time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void tap(int x, int y) {
		new TouchAction(getDriver()).tap(x, y).perform();
	}

	public static void clicarSeekBar(int delta, double posicao, By by) {

		MobileElement seek = getDriver().findElement(by);

		int y;
		int x;

		/**
		 * Primeiro defino qual a posição inicial o Y (Altura inicial do SeekBar) Depois
		 * defino qual o tamnho do Seek Bar e divido por dois, para achar a metade da
		 * altura total do Seekbar Depois somo a altura inicial do SeekBar com a metade
		 * da altura total do SeekBar (Será clicado nesta altura)
		 * 
		 */
		y = (seek.getLocation().y + (seek.getSize().height / 2));

		/**
		 * Primeiro defino qual a posição inicial do X (Posição inicial) e somo o valor
		 * delta (diferença do espaçamento até chegar na posição inicial do click)
		 * Depois defino o comprimento do Seek Bar (Tirando a diferença de delta da
		 * posição inicial e posição final) e multiplico o valor pela posição desejada
		 * do clique (Valor já passado em porcentagem) Depois somo as duas medidas para
		 * saber o local do click na posição X
		 * 
		 */
		x = (int) ((seek.getLocation().x + delta) + ((seek.getSize().width - 2 * delta) * posicao));

		// Realizo o click()
		tap(x, y);
	}

	private static void scroll(double inicio, double fim) {

		Dimension size = getDriver().manage().window().getSize();

		int x = size.width / 2;

		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		new TouchAction(getDriver()).press(x, start_y).waitAction(Duration.ofMillis(500)).moveTo(x, end_y).release()
				.perform();
	}

	public static void scrollDown() {
		scroll(0.9, 0.1);
	}

	public static void scrollUp() {
		scroll(0.1, 0.9);
	}

	private static void swipe(double inicio, double fim) {

		Dimension size = getDriver().manage().window().getSize();

		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);

		int y = size.height / 2;

		new TouchAction(getDriver()).press(start_x, y).waitAction(Duration.ofMillis(500)).moveTo(end_x, y).release()
				.perform();

	}

	public static void swipe(By by, double inicio, double fim) {

		MobileElement element = getDriver().findElement(by);

		int y = (element.getLocation().y) + (element.getSize().height / 2);

		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);

		new TouchAction(getDriver()).press(start_x, y).waitAction(Duration.ofMillis(500)).moveTo(end_x, y).release()
				.perform();

	}

	public static void swipeRight() {
		swipe(0.9, 0.1);
	}

	public static void swipeleft() {
		swipe(0.1, 0.9);
	}

	public static String[] obterLista(By by) {

		List<MobileElement> elements = getDriver().findElements(by);
		String[] retorno = new String[elements.size()];

		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
		}

		return retorno;
	}

	public static void arrastar(String origem, String destino) {

		MobileElement inicio = getDriver().findElement(By.xpath("//*[@text='" + origem + "']"));
		MobileElement fim = getDriver().findElement(By.xpath("//*[@text='" + destino + "']"));

		new TouchAction(getDriver()).longPress(inicio).moveTo(fim).release().perform();
	}

	public static void entrarContextoWeb() {
		Set<String> contextHandles = getDriver().getContextHandles();

		getDriver().context((String) contextHandles.toArray()[1]);
	}

	public static void sairContexto() {
		Set<String> contextHandles = getDriver().getContextHandles();

		getDriver().context((String) contextHandles.toArray()[0]);
	}

	public static String recuperarTextoElemento(By by) {
		
		return getDriver().findElement(by).getText();
	}
}
