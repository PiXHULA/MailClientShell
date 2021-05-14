package util;

import domain.Mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

public class Sender {

    public void send(Mail mail) throws IOException {

        final String username = "mailaddress";
        final String password = "password";

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(username));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getReceiver()));
            msg.setSubject(mail.getSubject());

            Multipart multipart = new MimeMultipart();

            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(mail.getMail());

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            if (mail.isAttachFile()) {
                DataSource source = new FileDataSource(mail.getFilepath());
                attachmentBodyPart.setDataHandler(new DataHandler(source));
                attachmentBodyPart.setFileName(mail.getFilename());
                multipart.addBodyPart(attachmentBodyPart);
            }

            multipart.addBodyPart(textBodyPart);

            msg.setContent(multipart);


            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
