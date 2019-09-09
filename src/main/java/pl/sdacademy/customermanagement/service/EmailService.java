package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmailService {
    public void send(String to, String from, final String username, final String password, String msg, String subject, String attachFile) {
        Properties prop = new Properties();
        /*//tls
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");*/

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "465");


        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);

            message.addHeader("Disposition-Notification-To", from);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(msg,"text/html;charset=UTF-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            MimeBodyPart attachPart = new MimeBodyPart();
            //String attachFile = "C:/install/konkurs.pdf";
            attachPart.attachFile(attachFile);

            multipart.addBodyPart(attachPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Wiadomość wysłana z powodzeniem ");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Wiadomość nie została wysłana");
            e.printStackTrace();
        }
    }
}
