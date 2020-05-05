package sogeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sogeti.model.User;
import sogeti.model.service.UserService;

import java.util.HashMap;
import java.util.Map;

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
        return new ModelAndView("homepage.html");
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
    public ModelAndView editUser(User user, Model model) {
        service.save(user);
        model.addAttribute("user", user);
        return new ModelAndView("profile.html");
    }

    @GetMapping("/profile/disable")
    public void disableProfile() {
    }

    @GetMapping("/doctor")
    public ModelAndView showCreateAccountByDoctor(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("createaccount.html");
    }

    @PostMapping("/doctor")
    public ModelAndView saveUserDoctor(@ModelAttribute("user") User user, Model model) {
        service.save(user);
        return new ModelAndView("homepage.html");
    }
}
