package sogeti.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sogeti.model.User;
import sogeti.model.repository.RoleRepository;
import sogeti.model.repository.UserRepository;

@Service
public class UserService {

    private User authUser;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getAuthUser() {
        return authUser;
    }

    public void setAuthUser(User user) {
        authUser = user;
    }
}
