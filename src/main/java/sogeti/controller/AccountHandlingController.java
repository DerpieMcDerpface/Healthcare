package sogeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import sogeti.model.User;
import sogeti.model.service.UserService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@Controller
@RequestMapping(path = "/account")
public class AccountHandlingController<user> {


    @Autowired
    private UserService service;

    @GetMapping("/create")
    public ModelAndView showCreateAccountPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("createaccount.html");
    }

    @GetMapping("/profile")
    public ModelAndView showProfilePage(Model model) {
        User user = service.getAuthUser();
        if (user == null) {
            return new ModelAndView("404.html");
        } else {
            model.addAttribute("user", user);
            return new ModelAndView("profile.html");
        }
    }

    @GetMapping("/profile/edit")
    public ModelAndView showProfileEditPage(Model model) {
        User user = service.getAuthUser();
        if (user == null) {
            return new ModelAndView("404.html");
        } else {
            model.addAttribute("user", user);
            return new ModelAndView("editprofile.html");
        }
    }

    @PostMapping("/profile/edit")
    public ModelAndView editUser(@RequestParam(name = "username") String username,
                                 @RequestParam(name = "surname") String surname,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "email") String email,
                                 Model model) {
        User user = service.findUserByUsername(username);
        user.setName(name);
        user.setEmail(email);
        user.setSurname(surname);
        if (user == null) {
            return new ModelAndView("404.html");
        } else {
            service.save(user);
            service.setAuthUser(user);
            model.addAttribute("user", user);
            return new ModelAndView("profile.html");
        }
    }

    @GetMapping("/profile/disable")
    public ModelAndView disableProfile(Model model) {
        User user = service.getAuthUser();
        if (user == null) {
            return new ModelAndView("404.html");
        } else {
            user.setActivated(false);
            service.save(user);
            return new ModelAndView("index.html");
        }
    }

    @GetMapping("/doctor")
    public ModelAndView showCreateAccountByDoctor(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("createaccount.html");
    }

    @PostMapping("/create")
    public RedirectView saveUserDoctor(@ModelAttribute("user") User user,
                                       @RequestParam(name="email") String email,
                                       @RequestParam(name="username") String username,
                                       @RequestParam(name="password") String password,
                                       Model model) throws IOException, MessagingException {

        service.save(user);
        StringBuilder sb = new StringBuilder();
        sb.append("Votre docteur a créé un compte pour vous, voici vos identifiants").append(" \n").append(" \n");
        sb.append("Nom d'utilisateur :").append(username).append(" \n");
        sb.append("Mot de passe : ").append(password).append(" \n");
        sendAccountDetailsEmail(sb.toString(),email);
        return new RedirectView("/homepage");
    }

    protected static void sendAccountDetailsEmail(String textForEmail, String userMail) throws AddressException, MessagingException, IOException {
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
        msg.setSubject("Compte Healthcare App");
        msg.setContent(textForEmail, "text/html");

        Transport.send(msg);
    }
}
