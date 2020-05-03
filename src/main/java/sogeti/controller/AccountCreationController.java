package sogeti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import sogeti.model.User;

@Controller
public class AccountCreationController {

    @RequestMapping("/register")
    public ModelAndView showRegisterUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("createaccount.html");
    }

}
