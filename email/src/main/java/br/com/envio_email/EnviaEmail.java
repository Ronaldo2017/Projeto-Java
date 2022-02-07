package br.com.envio_email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class EnviaEmail {

	// verificar as configurações smtp do email

	private String userName = "ronaldocostateste@gmail.com";
	private String senha = "Ron@2020";

	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";

	public EnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}

	public void enviarEmail(boolean envioHtml) throws Exception {

		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*");// autorização de segurança
		properties.put("mail.smtp.auth", "true");// autorização
		properties.put("mail.smtp.starttls", "true");// autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com");// servidor do gmail
		properties.put("mail.smtp.port", "465");// porta do servidor
		properties.put("mail.smtp.socketFactory.port", "465");// escifica a porta a ser conectada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// classe socket de
																							// conexão ao smtp

		// conexão
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(userName, senha);
			}
		});

		// destinatario
		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		Message mensagem = new MimeMessage(session);
		mensagem.setFrom(new InternetAddress(userName, nomeRemetente));// quem esta enviando
		mensagem.setRecipients(Message.RecipientType.TO, toUser);// email de destino
		mensagem.setSubject(assuntoEmail);// assunto do email
		mensagem.setText(textoEmail);

		if (envioHtml) {
			mensagem.setContent(textoEmail, "text/html; charset=utf-8");
		} else {
			mensagem.setText(textoEmail);
		}

		// envio
		Transport.send(mensagem);

	}

	public void enviarEmailAnexo(boolean envioHtml) throws Exception {

		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*");// autorização de segurança
		properties.put("mail.smtp.auth", "true");// autorização
		properties.put("mail.smtp.starttls", "true");// autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com");// servidor do gmail
		properties.put("mail.smtp.port", "465");// porta do servidor
		properties.put("mail.smtp.socketFactory.port", "465");// escifica a porta a ser conectada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// classe socket de
																							// conexão ao smtp

		// conexão
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(userName, senha);
			}
		});

		// destinatario
		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		Message mensagem = new MimeMessage(session);
		mensagem.setFrom(new InternetAddress(userName, nomeRemetente));// quem esta enviando
		mensagem.setRecipients(Message.RecipientType.TO, toUser);// email de destino
		mensagem.setSubject(assuntoEmail);// assunto do email
		mensagem.setText(textoEmail);

		/* primeira parte do email que é o texto e a descriçao do email */
		MimeBodyPart corpoEmail = new MimeBodyPart();

		if (envioHtml) {
			corpoEmail.setContent(textoEmail, "text/html; charset=utf-8");
		} else {
			corpoEmail.setText(textoEmail);
		}

		// lista de arquivos
		List<FileInputStream> arquivos = new ArrayList<FileInputStream>();
		arquivos.add(silumadorDePDF());
		arquivos.add(silumadorDePDF());
		arquivos.add(silumadorDePDF());
		arquivos.add(silumadorDePDF());

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(corpoEmail);

		int index = 0;
		for (FileInputStream fileInputStream : arquivos) {

			// segunda parte do email, esse é o anexo
			MimeBodyPart anexoEmail = new MimeBodyPart();

			// é o passado o simulador de pdf, passa o arquivo gravado no BD
			anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(fileInputStream, "application/pdf")));
			anexoEmail.setFileName("anexoEmail" + index + ".pdf");

			// junta as partes

			multipart.addBodyPart(anexoEmail);
			index ++;
			
		}
		mensagem.setContent(multipart);

		// envio
		Transport.send(mensagem);

	}

	// metodo simula o PDF ou qualquer arquivo que possa ser enviado em anexo no
	// email
	// pode pegar o arquivo do BD base64, byte[], Stream de arquvos ou em pasta
	// retorna um pdf em branco com o texto do paragrafo de exemplo
	private FileInputStream silumadorDePDF() throws Exception {
		Document document = new Document();// cria o documento em tempo de execução
		File file = new File("fileanexo.pdf");
		file.createNewFile();
		PdfWriter.getInstance(document, new FileOutputStream(file));// escrevendo o conteudo do arquivo
		document.open();
		document.add(new Paragraph("Conteúdo do PDF anexo com Java Mail, esse texto é do PDF."));
		document.close();

		return new FileInputStream(file);
	}

}
