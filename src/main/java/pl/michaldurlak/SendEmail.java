package pl.michaldurlak;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class SendEmail {


    public static void sendEmailTest(String recipientEmail, String messageSubject, String messageBody) {

            final String fromEmail = System.getenv("SMTP_FROMADDRESS"); //requires valid gmail id
            final String password = System.getenv("SMTP_FROMPASSWORD"); // correct password for gmail id
            final String toEmail = recipientEmail; // can be any email id

            System.out.println("Email Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", System.getenv("SMTP_ADDRESS")); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);


            EmailUtil.sendEmail(session,fromEmail, toEmail,messageSubject, messageBody);

    }
}
