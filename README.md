<h1 align="center" id="title">Send Email Using Java(Core Java)</h1>

<p id="description">The Java Email Sender application built entirely with core Java empowers users to send emails programmatically. With a robust architecture, the application seamlessly handles SMTP server configuration email session management and exception handling.</p>

  
  
<h2>🧐 Features</h2>

Here are some of the project's best features:

*   User can send email without attachment
*   User can send with the attachment.




<h2>🛠️ Steps for creating :</h2>

<p>1. Step 1: Configure the SMTP server details using the Java Properties Object (either you can create a separate file or write in the main file; creating a separate file is a good option because you don't have to modify your code again and again; instead you can provide details from this file only).</p>

```
Properties properties = new Properties();
properties.put("mail.smtp.auth" true);
properties.put("mail.smtp.starttls.enable" true);
properties.put("mail.smtp.port" 587);
properties.put("mail.smtp.host" "smtp.gmail.com");
```

<p>2. Step 2: Create a Session with getInstance() and pass properties and Authenticator and override getPasswordAuthentication() method. Authenticator is an abstract class so we have to implement that class and override the method.</p>

```
final String username = "krishankantsinghtesting@gmail.com";
final String password = "******your password*****";
//Step 2 Getting the session
Session session = Session.getInstance(properties new Authenticator() {
  @Override
  protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username password);
    }
  });
```

<p>3. Step 3: Now create a message; we can use the MimeMessage class. The Message class represents the Message(class). MimeMessage is an implementation class of the Message class.</p>

```
//Step 3 creating MimeMessage
Message message = new MimeMessage(session);
```

<p>4. Step 4: Set the to from subject message etc.</p>

```
//Step 4 Setting up from to subject etc.
message.setRecipient(Message.RecipientType.TO new InternetAddress(to));
message.setFrom(new InternetAddress(from));
message.setSubject(subject);
message.setText(messageText); 			
```

<p>5. Step 5: Use the Transport class to send the mail. (The Transport class has a static method send() to send the mail).</p>

```
//Step 5 Sening using Transport class
Transport.send(message);
```

<p>6. Final Step: Call the main method:</p>

```
//Main method: String to = "kksg1999@gmail.com";
String from = "krishankantsinghtesting@gmail.com";
String subject = "Mail with text and file attachments";
String message = "Hello Krishan Kant Singh How are you? "
    + "\n Thank you for your email. Have a great day! "
    + "\n Regards "
    + "\n Krishan Kant Singh";
String filePath = "file\path\here";
File file = new File(filePath);
boolean isSentFile = myEmailSender.sendEmailWithAttachment(to fromsubjectmessage file);
if (isSentFile) 
  System.out.println("Email sent successfully"); 		
else
  System.out.println("Email not sent! Please try again"); 
```

  
  
<h2>💻 Built with</h2>

Technologies used in the project:

*   Java
*   Maven
