package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		
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
		

		File arquivo = new File("C:\\workspace-curso-java\\Arquivos\\src\\arquivos.csv");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escreverNoArquivo = new FileWriter(arquivo);
		
				
		/*for(int i = 1; i <= 10; i ++) {
			escreverNoArquivo.write("Meu primeiro texto de arquivo da linha " + i + "\n");
		}*/
		
		for (Pessoa p : pessoas) {
			escreverNoArquivo.write(p.getNome() + ";" + p.getEmail() + 
					";" + p.getIdade() + "\n");
		}
		
		escreverNoArquivo.flush();//persiste a escrita do arquivo
		escreverNoArquivo.close();//fechar o arquivo
		
	}

}
