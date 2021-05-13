import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailSender {
    public static void main(String[] args) throws IOException {


        final String username = "emailaddress";
        final String password = "password";


        Properties props = new Properties();
        props.put("mail.debug", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,  new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Mail mail;
        Reader reader = new Reader();
        mail = reader.read();
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail.getReceiver())
            );
            message.setSubject(mail.getSubject());
            message.setText(mail.getMail());

            Transport.send(message);

            System.out.println("Sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
