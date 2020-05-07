package sogeti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sogeti.model.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import java.util.Random;

@Controller
public class PasswordController {

    @Autowired
    UserService service;

    @GetMapping("/resetpass")
    public ModelAndView showResetPass(Model model) {
        return new ModelAndView("ResetPass.html");
    }

    private static String generateSecurityCode(){
        Random random = new Random();
        char[] letters = new char[]{'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j'
                ,'K','k','L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v'
                ,'W','w','X','x','Y','y','Z','z','0','1','2','3','4','5','6','7','8','9','-','!','?'};

        StringBuilder securityCode= new StringBuilder();
        int index = 0;

        for (int i = 0; i < 10; i++) {
            index = random.nextInt(36);
            securityCode.append(letters[index]);
        }
        return securityCode.toString();
    }


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
