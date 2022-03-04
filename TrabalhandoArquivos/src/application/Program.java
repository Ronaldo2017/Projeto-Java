package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		File file = new File("C:\\novoArquivo.txt");
		
		//instanciar scanner para ler o file
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			//se existe uma nova linha no arquivo
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			if(sc != null) {
				sc.close();
			}
			
		}
	}
}
