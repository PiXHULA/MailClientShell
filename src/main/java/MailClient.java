import domain.Mail;
import util.Reader;
import util.Sender;

import java.io.IOException;

public class MailClient {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        Sender sender = new Sender();

        Mail mail = reader.createMail();
        sender.send(mail);
    }
}
