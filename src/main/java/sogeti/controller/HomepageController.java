package sogeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sogeti.model.News;
import sogeti.model.User;
import sogeti.model.service.NewsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomepageController {

    @Autowired
    private NewsService newsService;
    private List<News> newsList;

    @GetMapping("/homepage")
    public ModelAndView showHomepage() {
        Map<String, Object> model = new HashMap<>();

        newsList = newsService.getAllNews();
        News news = newsList.get(0);

        model.put("news", news);
        return new ModelAndView("homepage.html", model);
    }
}
