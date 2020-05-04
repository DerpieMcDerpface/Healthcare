package sogeti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {

    @GetMapping("/homepage")
    public ModelAndView showHomepage() {
        return new ModelAndView("homepage.html");
    }

}
