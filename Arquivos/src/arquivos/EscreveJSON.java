package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;



public class EscreveJSON {
	
	public static void main(String[] args) {
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("45454435413");
		usuario1.setLogin("Joao");
		usuario1.setSenha("joao");
		
		Usuario usuario2 = new Usuario();
		
		usuario2.setCpf("543554656");
		usuario2.setLogin("juca");
		usuario2.setSenha("juca");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter
				("C:\\workspace-curso-java\\Arquivos\\src\\arquivos\\arquivo_json.json");
		
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		//------------LENDO O ARQUIVO JSON---------------
		FileReader fileReader = new FileReader("C:\\workspace-curso-java\\Arquivos\\src\\arquivos\\arquivo_json.json");
		
		JsonArray jsonArray = JsonParser.parseReader(fileReader);
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listaUsuarios.add(usuario);
		}
		
		System.out.println("Leitura do arquivo JSOn: " + listaUsuarios);
	}

}
