package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import com.sun.rowset.internal.Row;

public class ApachePoiEditando2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("C:\\workspace-curso-java\\Arquivos\\src\\arquivos.csv");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkbook = new HSSFWordbook(entrada)//prepara a entrada do arquivo xls excel
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);//pega a planilha
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) {//enquanto tiver linha
			Row linha = linhaIterator.next();//dados da pessoa na linha
			
			
			
			String valorCelula = linha.getCell(0).getStringCellValue();
			
			linha.getCell(0).setCellValue(valorCelula + " * Valor gravado na aula");
		}
		
		entrada.close();
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada!");
	}

}
