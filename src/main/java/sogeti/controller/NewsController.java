package sogeti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sogeti.model.News;
import sogeti.model.service.NewsService;

import java.util.List;

@Controller
public class NewsController {




    @GetMapping("/newspage")
    public ModelAndView showNews() {
        return new ModelAndView("newspage.html");
    }

}