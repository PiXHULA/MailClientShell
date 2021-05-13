public class Mail {
    private final String receiver;
    private final String subject;
    private final String mail;

    private Mail(MailBuilder mailBuilder) {
        this.receiver = mailBuilder.receiver;
        this.subject = mailBuilder.subject;
        this.mail = mailBuilder.mail;
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

    public static final class MailBuilder {
        String receiver;
        String subject;
        String mail;

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

        public Mail build() {
            return new Mail(this);
        }
    }
}
