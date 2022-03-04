package caminhoDoArquivo;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a file path: ");
		String strPath = sc.nextLine();

		File path = new File(strPath);

		// acessar somente o nome do arquivo
		System.out.println("getName: " + path.getName());
		// acessar somente o caminho
		System.out.println("getParent: " + path.getParent());
		// acessar somente o caminho completo
		System.out.println("getPath: " + path.getPath());

	}

}
