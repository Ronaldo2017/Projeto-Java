package br.com.envio_email;

import org.junit.Test;

public class AppTest {

	@Test
	public void testeEmail() throws Exception {

		//fazendo html
		StringBuilder stringBuilderTextoEmail = new StringBuilder();

		stringBuilderTextoEmail.append("Olá, <br/><br/>");
		stringBuilderTextoEmail.append("Ronaldo é desenvolvedor Java. <br/><br/>");
		stringBuilderTextoEmail.append("Para contatar clique no link abaixo. <br/><br/>");
		stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"https://outlook.live.com/mail\" "
				+ "style=\"color:#2525a7; padding:"
				+ "14px 25px; text-align:center; text-decoration:none;"
				+ "display:inline-block; border-radius:30px; "
				+ "font-size:20px; font-family:courier; border:3px solid green;"
				+ "background-color:#99DA39;\">Contato</a>");

		EnviaEmail enviaEmail = new EnviaEmail("costaronaldoluis@gmail.com", "Ronaldo, Desenvolvedor Java",
				"Teste de envio de email com Java", stringBuilderTextoEmail.toString());

		enviaEmail.enviarEmailAnexo(true);

		// somente para testes
		Thread.sleep(3000);

	}

}
