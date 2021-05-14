package util;

import domain.Mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    BufferedReader reader;
    String receiver;
    String subject;
    StringBuilder mail;
    String fileName;
    boolean attachFile;

    public Mail createMail() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Receiver: "); System.out.flush();
        receiver = reader.readLine();
        System.out.print("Subject: "); System.out.flush();
        subject = reader.readLine();
        System.out.print("Attach file? "); System.out.flush();
        attachFile = Boolean.parseBoolean(reader.readLine());
        if (attachFile) {
            System.out.print("Filename: ");
            System.out.flush();
            fileName = reader.readLine();
        }
        System.out.print("Body: "); System.out.flush();
        String nextline = "";
        mail = new StringBuilder();
        try {
            while ((nextline = reader.readLine()) != null) {
                mail.append(nextline);
                mail.append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Mail mailObj = Mail.MailBuilder.aMail()
                .withMail(mail.toString())
                .withReceiver(receiver)
                .withSubject(subject)
                .withAttachFile(attachFile)
                .withFilename(fileName)
                .withFilepath("/mnt/c/Users/Username/Desktop/"+fileName)
                .build();

        return mailObj;
    }
}

