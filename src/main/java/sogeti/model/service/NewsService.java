package sogeti.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sogeti.model.News;
import sogeti.model.repository.NewsRepository;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public News getNews(int id) {
        return newsRepository.findById(id);
    }
}
