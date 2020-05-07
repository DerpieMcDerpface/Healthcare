package sogeti.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class PasswordController {

    public void sendmail(String rdCode, String userMail) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("hcare67000@gmail.com", "Equipedeschieurs");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(userMail, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userMail));
        msg.setSubject("Changement de mot de passe");
        msg.setContent("Votre nouveau mot de passe est : "+ rdCode, "text/html");

        Transport.send(msg);
    }

}
