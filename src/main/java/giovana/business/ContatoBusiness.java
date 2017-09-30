package giovana.business;

import giovana.model.Contato;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContatoBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

//	@SuppressWarnings("deprecation")
//	public void enviarEmail(Contato contato) throws Exception {
//		SimpleEmail email = new SimpleEmail();
//		email.setHostName("smtp.gmail.com");
//		email.addTo("giovanasilveiracardoso@gmail.com", "Giovana"); // destinatário
//		email.setFrom("giovanasilveiracardoso@gmail.com", "Site"); // remetente
//		email.setSubject("[ SITE ] E-mail Contato"); // assunto do e-mail
//		email.setAuthentication("giovanasilveiracardoso@gmail.com", "992696312$6");
//		email.setSmtpPort(465);
//		email.setSSL(true);
//		email.setTLS(true);
//		
//		StringBuilder stringBuilder = new StringBuilder();
//		stringBuilder.append("Nome: ");
//		stringBuilder.append(contato.getNome());
//		stringBuilder.append("\n");
//		stringBuilder.append("E-mail: ");
//		stringBuilder.append(contato.getEmail());
//		stringBuilder.append("\n");
//		stringBuilder.append("Assunto: ");
//		stringBuilder.append(contato.getAssunto());
//		stringBuilder.append("\n");
//		stringBuilder.append("Descrição: ");
//		stringBuilder.append(contato.getDescricao());
//		email.setMsg(stringBuilder.toString()); // conteudo do e-mail
//
//		email.send();
//	}
	
	public void enviarEmail(Contato contato) throws Exception{
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", 465); 
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.auth", true); 
		props.put("mail.smtp.port", 465);

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("giovanasilveiracardoso@gmail.com", "992696312$6");
			}
		});
		
		session.setDebug(true);
		
		MimeMessage message = new MimeMessage(session);
		
		String from = contato.getEmail();
		message.setFrom(new InternetAddress(from));
		
		String to = "giovanasilveiracardoso@gmail.com";
		Address toAddress = new InternetAddress(to);
		message.addRecipient(Message.RecipientType.TO, toAddress);
		
		message.setSubject(contato.getAssunto());
		
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Nome: ");
		mensagem.append(contato.getNome());
		mensagem.append("\n");
		mensagem.append("E-mail: ");
		mensagem.append(contato.getEmail());
		mensagem.append("\n");
		mensagem.append("Assunto: ");
		mensagem.append(contato.getAssunto());
		mensagem.append("\n");
		mensagem.append("Descrição: ");
		mensagem.append(contato.getDescricao());
		message.setText(mensagem.toString());
		
		Transport.send(message);
	}
}
