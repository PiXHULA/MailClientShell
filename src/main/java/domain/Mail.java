package domain;

public class Mail {
    private final String receiver;
    private final String subject;
    private final String mail;
    private final boolean attachFile;
    private final String filepath;
    private final String filename;

    private Mail(MailBuilder mailBuilder) {
        this.receiver = mailBuilder.receiver;
        this.subject = mailBuilder.subject;
        this.mail = mailBuilder.mail;
        this.attachFile = mailBuilder.attachFile;
        this.filepath = mailBuilder.filepath;
        this.filename = mailBuilder.filename;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public String getMail() {
        return mail;
    }

    public String getFilepath() {
        return filepath;
    }

    public String getFilename() {
        return filename;
    }

    public boolean isAttachFile() {
        return attachFile;
    }


    public static final class MailBuilder {
        private String receiver;
        private String subject;
        private String mail;
        private boolean attachFile;
        private String filepath;
        private String filename;

        private MailBuilder() {
        }

        public static MailBuilder aMail() {
            return new MailBuilder();
        }

        public MailBuilder withReceiver(String receiver) {
            this.receiver = receiver;
            return this;
        }

        public MailBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public MailBuilder withMail(String mail) {
            this.mail = mail;
            return this;
        }

        public MailBuilder withAttachFile(boolean attachFile) {
            this.attachFile = attachFile;
            return this;
        }

        public MailBuilder withFilepath(String filepath) {
            this.filepath = filepath;
            return this;
        }

        public MailBuilder withFilename(String filename) {
            this.filename = filename;
            return this;
        }

        public Mail build() {
            return new Mail(this);
        }
    }
}
