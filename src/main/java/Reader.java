import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    public Mail read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Receiver: ");
        System.out.flush();
        String receiver = br.readLine();
        System.out.print("Subject: ");
        System.out.flush();
        String subject = br.readLine();
        System.out.print("Body: ");
        System.out.flush();
        String nextline = "";
        StringBuilder mail = new StringBuilder();
        try {
            while ((nextline = br.readLine()) != null)
            {
                mail.append(nextline);
                mail.append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Mail mailObj = Mail.MailBuilder.aMail()
                .withMail(mail.toString())
                .withReceiver(receiver)
                .withSubject(subject)
                .build();

        return mailObj;
    }
}

