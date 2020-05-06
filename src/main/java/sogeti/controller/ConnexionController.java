package sogeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import sogeti.model.User;
import sogeti.model.service.UserService;

@Controller
public class ConnexionController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/connect")
    public ModelAndView showIndexPage(Model model){
        return new ModelAndView("index.html");
    }

    @PostMapping(path="/connect")
    public RedirectView connect(@RequestParam(name = "username") String username,
                                @RequestParam(name="password") String password,
                                Model model){
        if(userService.findUserByUsername(username) != null && userService.findUserByUsername(username).getPassword().equals(password)){
            User user = userService.findUserByUsername(username);
            userService.setAuthUser(user);
            model.addAttribute("user", user);
            return new RedirectView("/homepage");
        }
        else{
            return new RedirectView("/connect");
        }
    }
}
