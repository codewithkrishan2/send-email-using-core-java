package email;

import java.io.File;

public class EmailSender {

	public static void main(String[] args) {
		MyEmailGenerator myEmailSender = new MyEmailGenerator();
		
		String to = "kksg1999@gmail.com";
		String from = "krishankantsinghtesting@gmail.com";
		String subject = "Mail with text and file attachments";
		String message = "Hello, Krishan Kant Singh, How are you? "
				+ "\n Thank you for your email. Have a great day! "
				+ "\n Regards, "
				+ "\n Krishan Kant Singh";
		String filePath = "C:\\Users\\kksg1\\OneDrive\\Desktop\\Diwali 2023\\DSC_2790.jpg";
		File file = new File(filePath);
		
		/*
		boolean isSent = myEmailSender.sendEmail(to, from,subject,message);
		
		if (isSent) {
			System.out.println("Email sent successfully");
		}
		
		else {
			System.out.println("Email not sent! Please try again");
		
		}
		*/
		boolean isSentFile = myEmailSender.sendEmailWithAttachment(to, from,subject,message, file);
		if (isSentFile) {
			System.out.println("Email sent successfully");
		}
		
		else {
			System.out.println("Email not sent! Please try again");
		
		}
	}

}
