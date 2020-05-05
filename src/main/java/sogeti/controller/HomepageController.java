package sogeti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sogeti.model.User;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomepageController {

    @GetMapping("/homepage")
    public ModelAndView showHomepage() {
        return new ModelAndView("homepage.html");
    }
}
