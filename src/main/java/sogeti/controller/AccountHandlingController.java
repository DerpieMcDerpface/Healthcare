package sogeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sogeti.model.User;
import sogeti.model.service.UserService;

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

    @PostMapping("/create")
    public ModelAndView saveUser(@ModelAttribute("user") User user, Model model) {
        service.save(user);
        return new ModelAndView ("homepage.html");
    }

    @GetMapping("/doctor")
    public ModelAndView showCreateAccountByDoctor(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return new ModelAndView("createaccount.html");
    }

    @PostMapping("/doctor")
    public ModelAndView saveUserDoctor(@ModelAttribute("user")User user, Model model){
        service.save(user);
        return new ModelAndView ("homepage.html");
    }
}
