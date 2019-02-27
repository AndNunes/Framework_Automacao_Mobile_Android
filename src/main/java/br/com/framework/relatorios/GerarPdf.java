package br.com.framework.relatorios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.framework.evidencias.Evidencias;
import br.com.framework.utils.BaseTeste;

public class GerarPdf {

	public static void montaPdf() {
		// criação do documento
		Document document = new Document();
		Image imagem;

		try {

			PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.dir")+"\\relatorios_Pdf\\"+BaseTeste.nomeTeste+".pdf"));
			document.open();

			// adicionando um parágrafo no documento
			document.add(new Paragraph("Relatorio de Execução dos Testes"));

			for (int i = 1; i <= Evidencias.getNumeroEvidencias(); i++) {

				imagem = Image.getInstance(System.getProperty("user.dir") + "\\evidencias\\realizarLogin\\EV_"+i+".png");
				imagem.scaleToFit(1000, 500);

				document.add(imagem);
				document.add(new Paragraph("   "));

			}

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
	}

}
