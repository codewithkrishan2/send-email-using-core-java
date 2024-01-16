package email;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class MyEmailGenerator {

	public boolean sendEmail(String to, String from, String subject, String messageText) {

		boolean flag = false;
		
		//STEP :1 Configure the SMTP server details (Setting smtp properties)
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.host", "smtp.gmail.com");

		final String username = "krishankantsinghtesting@gmail.com";
		final String password = "xvqh ltkj usrb bfjv";

		//Step 2 Getting the session
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);
			}
		});

		try {
			//Step 3 creating MimeMessage
			Message message = new MimeMessage(session);
			
			//Step 4 Setting up from, to, subject etc.
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
			message.setText(messageText);
			
			
			//Step 5 Sening using Transport class
			Transport.send(message);
			
			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean sendEmailWithAttachment(String to, String from, String subject, String messageText, File file) {
		
		boolean flag = false;
		//STEP :1 Configure the SMTP server details (Setting smtp properties)
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.host", "smtp.gmail.com");

		final String username = "krishankantsinghtesting@gmail.com";
		final String password = "xvqh ltkj usrb bfjv";

		//Step 2 Getting the session
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			//create Message
			Message myMessage = new MimeMessage(session);
			myMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			myMessage.setFrom(new InternetAddress(from));
			myMessage.setSubject(subject);
			myMessage.setText(messageText);
			
			MimeBodyPart part1 = new MimeBodyPart();
			part1.setText(messageText);
			
			MimeBodyPart part2 = new MimeBodyPart();
			part2.attachFile(file);
			
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart(part1);
			mimeMultipart.addBodyPart(part2);
			
			myMessage.setContent(mimeMultipart);
			
			Transport.send(myMessage);
			
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
