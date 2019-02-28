package br.com.framework.relatorios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.framework.evidencias.Evidencias;
import br.com.framework.utils.BaseTeste;
import br.com.framework.utils.Driver;

public class GerarPdf {

	public static void montaPdf() {
		// criação do documento
		Document document = new Document();

		try {
			
			configuraDocument(document);
			PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.dir") + "\\relatorios_Pdf\\" + BaseTeste.nomeTeste + ".pdf"));
			document.open();
			
			
			addLogoDocumento(document); //Chama método para adicionar o log no inicio do documento
			tituloDocumento(document); //Método que adiciona o título do documento
			document.add(new Paragraph(" "));//Pular linha
			montaCabecalho(document); //Método que monta o cabecalho do documento
			document.add(new Paragraph(" ")); //pula linha
			adicionaEvidencias(document); //Método para adicionar as evidencias

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
	}

	private static void configuraDocument(Document document) {
		
		document.setPageSize(PageSize.A4);
		document.setMargins(10, 2, 10, 2);
		document.addAuthor("Anderson");
	}
	
	private static void addLogoDocumento(Document document) {
		
		Image imagemCabecalho = null;

		try {
			imagemCabecalho = Image.getInstance("C:\\Users\\PC-Notebook\\Documents\\logo_Foton.png");
			imagemCabecalho.scaleToFit(1000, 100);
			imagemCabecalho.getAbsoluteX();
			document.add(imagemCabecalho);
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Método responsável por adicionar as evidências no documento
	 * 
	 * */
	private static void adicionaEvidencias(Document document) {

		Image imagem;
		
		Paragraph tituloEvidencias = new Paragraph("Evidências", tipoFonte("Titulo Evidencias"));
		tituloEvidencias.setAlignment(Element.ALIGN_CENTER);
		try {
			document.add(tituloEvidencias);
			document.add(new Paragraph(" "));
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}

		for (int i = 1; i <= Evidencias.getNumeroEvidencias(); i++) {

			try {
				
				imagem = Image.getInstance(System.getProperty("user.dir") + "\\evidencias\\realizarLogin\\EV_" + i + ".png");
				imagem.scaleToFit(1000, 500);
				imagem.setAlignment(Element.ALIGN_CENTER);
				document.add(imagem);
				document.add(new Paragraph(" "));

			} catch (BadElementException e) {	
				e.printStackTrace();
			} catch (MalformedURLException e) {		
				e.printStackTrace();
			} catch (IOException e) {	
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}

	private static void tituloDocumento(Document document) {

		try {

			// Crio o Paragrafo
			Paragraph tituloDocumento = new Paragraph("Relatorio de Execução dos Testes Automatizados", tipoFonte("Titulo"));
			// Alinho o Paragrafo Centralizado
			tituloDocumento.setAlignment(Element.ALIGN_CENTER);
			// Adiciono o Paragrafo ao documento
			document.add(tituloDocumento);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Método responsável por montar o cabeçalho do documento de evidência dos testes
	 * 
	 * */
	private static void montaCabecalho(Document document) {
		
		Paragraph cenarioTeste = new Paragraph("Cenário: " + BaseTeste.nomeTeste, tipoFonte("Cabecalho"));
		Paragraph paragrafoDevice = new Paragraph("Aparelho: " + Driver.leitorProerties.getValor("aparelhoExecucao"),
				tipoFonte("Cabecalho"));
		Paragraph plataformaExecucao = new Paragraph("Plataforma: " + Driver.leitorProerties.getValor("platformName"), tipoFonte("Cabecalho"));

		try {
			document.add(cenarioTeste);
			document.add(new Paragraph(""));
			document.add(paragrafoDevice);
			document.add(new Paragraph(""));
			document.add(plataformaExecucao);
			document.add(new Paragraph(""));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Método responsável por configurar as fontes utilizadas no documento
	 * 
	 * */
	private static Font tipoFonte(String tipoFonte) {

		Font font = null;

		if (tipoFonte.equals("Titulo")) {

			font = new Font(FontFamily.TIMES_ROMAN, 20, Font.ITALIC, BaseColor.RED);
		} else if (tipoFonte.equals("Cabecalho")) {

			font = new Font(FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
		}else if (tipoFonte.equals("Titulo Evidencias")) {
			
			font = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLDITALIC, BaseColor.BLUE);
		}

		return font;
	}

}
