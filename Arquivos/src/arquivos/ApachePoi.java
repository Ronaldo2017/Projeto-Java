package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class ApachePoi {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File
				("C:\\workspace-curso-java\\Arquivos\\src\\arquivos\\arquivo_excel.xls");
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		Pessoa p1 = new Pessoa();
		p1.setEmail("contato@contato.com");
		p1.setNome("Jubileu");
		p1.setIdade(25);
		Pessoa p2 = new Pessoa();
		p2.setEmail("contato@contato.com");
		p2.setNome("Joana");
		p2.setIdade(25);
		Pessoa p3 = new Pessoa();
		p3.setEmail("contato@contato.com");
		p3.setNome("Juca");
		p3.setIdade(25);
		
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook();//usado para escrever a planilha
		HSSFSheet linhasPessoas = hssfWorkbool.createSheet("Planilha de pessoas do Trinamento");//cria a planilha
		
		
		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoas.createRow(numeroLinha ++);//criando a linha na planilha
			
			int celula = 0;
			
			Cell celEmail = linha.createCell(celula ++);
			celEmail.setCellValue(p.getEmail());
			
			Cell celNome = linha.createCell(celula ++);
			celNome.setCellValue(p.getNome());
			
			Cell celIdade = linha.createCell(celula ++);
			celIdade.setCellValue(p.getIdade()));
			
		}//termino da montagem da planilha
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkBook.write(saida);//escreve a planilha em arquivo
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada!");
	}

}
