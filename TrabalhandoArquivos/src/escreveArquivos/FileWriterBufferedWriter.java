package escreveArquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterBufferedWriter {

	public static void main(String[] args) {
		
		String[] lines = new String[] {
				"Good Morning", "Goodi Afternoon", "Good night"
		};
		
		String path = "C:\\Users\\ronal\\Documents\\Docs1\\out.txt";
		
		//new FileWriter(path, true = nao recria o arquivo, sem os dois parametros ele recria
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
				bw.newLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
