package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import com.sun.rowset.internal.Row;

public class ApachePoi2 {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream entrada = new FileInputStream(new File("C:\\workspace-curso-java\\Arquivos\\src\\arquivos.csv"));
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);//prepara a entrada do arquivo excel para ler
		HSSFShet planilha = hssfWorkbook.getSheetAt(0);//pega a primeira planilha do nosso arquivo excel
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pesssoas = new ArrayList<Pessoa>();
		
		while(linhaIterator.hasNext()) {
			//enquanto tiver linha no arquivo
			Row linha = linhaIterator.next();//dados da pessoa na linha
			Iterator<Cell> celula = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while(celula.hasNext()) {
				//percorre as celulas
				Cell cell = celulas.next();
				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue);
					break;
				}//fim das celulas da linha
				
				pesssoas.add(pessoa);
				
				
			}
		}
		
		entrada.close();//termino da leitura do arquivo
		for (Pessoa pessoa : pesssoas) {
			System.out.println(pessoa);
		}
	}

}
