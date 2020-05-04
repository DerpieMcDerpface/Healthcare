package sogeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sogeti.model.User;
import sogeti.service.UserService;

@Controller
public class AccountCreationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView showRegisterUser(Model model) {
        
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("createaccount.html");
    }

    @PostMapping("/register")
    public ModelAndView saveUser(Model model) {
        return new ModelAndView ("/");
    }

}
