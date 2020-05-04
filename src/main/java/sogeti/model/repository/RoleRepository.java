package sogeti.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogeti.model.User;

public interface RoleRepository extends JpaRepository<User, String> {

}
