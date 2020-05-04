package sogeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sogeti.model.service.UserService;

@Controller
public class ConnexionController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/index")
    public ModelAndView showIndexPage(Model model){
        return new ModelAndView("index.html");
    }

    @PostMapping(path="/index")
    public ModelAndView connect(@RequestParam(name = "username") String username,
                                @RequestParam(name="password") String password,
                                Model model){
        if(userService.getUsername(username).getPassword().equals(password)){
            return new ModelAndView("homepage.html");
        }
        else{
            return new ModelAndView("index.html");
        }
    }
}
