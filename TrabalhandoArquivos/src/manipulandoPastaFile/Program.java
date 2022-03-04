package manipulandoPastaFile;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File (strPath);
		
		//lista todos as pastas do arquivo
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("Foldres: ");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		//somente os arquivos
		File[] files = path.listFiles(File::isFile);
		System.out.println("Files: ");
		for (File file : files) {
			System.out.println(file);
		}
		
		//cria subpasta
		boolean success = new File(strPath + "\\subdir").mkdir();
		System.out.println("Diretorio criado com sucesso: " + success);
		
		sc.close();

	}

}
