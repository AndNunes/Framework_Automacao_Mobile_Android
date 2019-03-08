package br.com.framework.test;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TesteExcel {

	public static void main(String[] args) throws BiffException, IOException {
		
		Workbook worbook = Workbook.getWorkbook(new File(System.getProperty("user.dir") + "\\Massa\\dados.xls"));
		
		Sheet sheet = worbook.getSheet(0);
		
		int linhas = sheet.getRows();
		
		System.out.println("Iniciando a leitura da planilha: >>> ");
		
		for (int i = 0; i < linhas; i++) {
			
			Cell a1 = sheet.getCell(0, i);

			Cell a2 = sheet.getCell(1, i);

			Cell a3 = sheet.getCell(2, i);
			
			String as1 = a1.getContents();
			String as2 = a2.getContents();
			String as3 = a3.getContents();
			
			System.out.println("Celula 1: " + as1);
			System.out.println("Celula 2: " + as2);
			System.out.println("Celula 3: " + as3);
		}
		
		worbook.close();
	}
	
}
