package sogeti.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogeti.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
