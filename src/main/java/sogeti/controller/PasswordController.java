package sogeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sogeti.model.service.UserService;

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

}
