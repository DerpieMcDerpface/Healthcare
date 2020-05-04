package sogeti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogeti.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
    User findByEmail(String email);
}
