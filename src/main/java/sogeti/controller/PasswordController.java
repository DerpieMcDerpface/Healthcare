package sogeti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import sogeti.model.User;
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
@RequestMapping(path = "/password")
public class PasswordController {

    @Autowired
    UserService service;

    @GetMapping("/reset")
    public ModelAndView showResetPass(Model model) {
        return new ModelAndView("forgotpassword.html");
    }

    @PostMapping("/reset")
    public RedirectView sendSecurityCode(Model model, @RequestParam(name="email") String email) throws IOException, MessagingException {
        System.out.println("email ="+email);
        System.out.println("user is null? = "+service.findUserByEmail(email)!=null);
        System.out.println("user is activated? = "+service.findUserByEmail(email).isActivated());

        if(service.findUserByEmail(email)!=null && service.findUserByEmail(email).isActivated()){
            String securityCode = generateSecurityCode();
            sendSecurityCodeEmail(securityCode, email);
            service.updateUserSecurityCode(service.findUserByEmail(email), securityCode);
            return new RedirectView("/password/edit");
        }
        System.out.println("On est dans le else de post reset pass");
        return new RedirectView("/password/reset");
    }

    @GetMapping("/edit")
    public ModelAndView showEditPass(Model model) {
        return new ModelAndView("editpassword.html");
    }

    @PostMapping("/edit")
    public ModelAndView resetPassword(@RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      @RequestParam("confirmpwd") String confirmPwd,
                                      @RequestParam("security-code") String securityCode,
                                      Model model){
        User user = new User();
        try{
            user = service.findUserByUsername(username);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        if(password.equals(confirmPwd) && user.getSecurityCode().equals(securityCode)){
            service.updateUserPassword(user, password);
            return new ModelAndView("index.html");
        }
        else{
            System.out.println("On est dans le else de post edit pass");
            if(!password.equals(confirmPwd)) System.out.println("Mots de passe différents");
            if(!user.getSecurityCode().equals(securityCode)) {
                System.out.println("Code de sécurité incorrect");
                System.out.println("securityCode = " + securityCode);
                System.out.println("actual : "+ user.getSecurityCode());
            }
            return new ModelAndView("editpassword.html");
        }
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


    protected static void sendSecurityCodeEmail(String securityCode, String userMail) throws AddressException, MessagingException, IOException {
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
        msg.setSubject("Réinitialisation de mot de passe");
        msg.setContent("Votre code de sécurité pour réinitialiser votre mot de passe est : "+ securityCode, "text/html");

        Transport.send(msg);
    }

}
