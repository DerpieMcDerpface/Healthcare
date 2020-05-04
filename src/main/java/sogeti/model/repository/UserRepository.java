package sogeti.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sogeti.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByPassword(String password);
}
