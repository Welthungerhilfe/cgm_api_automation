package api.utils;

import java.util.Properties;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

public static void main(String[] args) {
	
	final String hostname = "smtp.office365.com";
    final String port = "587";
    final String username = "pjena@childgrowthmonitor.org";
    final String password = "whh@451989";
    final String from = "pjena@childgrowthmonitor.org";
    final String to = "agupta@childgrowthmonitor.org";
    final String cc = "smahale@childgrowthmonitor.org";
    final String subject = "Rest Assured API Automation HTML Report";
    final String msg = "Hi Team,\r\n"
    		+ "Please find the attachment of RestAssured API Automation Test Reports."
    		
    		+ "Regards,\r\n"
    		+ "Testing Team";
    

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", hostname);
    props.put("mail.smtp.port", port);
    props.put("mail.smtp.ssl.protocols", "TLSv1.2");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
        message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(cc));
        message.setSubject(subject);
        message.setText(msg);

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        messageBodyPart = new MimeBodyPart();
        String filepath = (System.getProperty("user.dir") + "/ExtentReports/API Automation Extent Reports.html");
        String fileName = "API Automation Extent Reports.html";
        DataSource source = new FileDataSource(filepath);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);
  
        message.setContent(multipart);

        System.out.println("Sending Email...");

        Transport.send(message);

        System.out.println("=====Email Sent Successfully=====");

    } catch (MessagingException e) {
        e.printStackTrace();
        System.out.println("!!!Not able to Sent!!!");
    }
  }
}