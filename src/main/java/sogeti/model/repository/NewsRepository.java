package sogeti.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogeti.model.News;

public interface NewsRepository extends JpaRepository<News,Integer> {

    News findById(int id);

}
