package sogeti.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogeti.model.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Integer> {
    List<News> findAll();
    News findById(int id);

}
