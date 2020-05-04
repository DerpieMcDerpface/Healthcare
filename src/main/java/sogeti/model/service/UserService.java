package sogeti.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sogeti.model.User;
import sogeti.model.repository.RoleRepository;
import sogeti.model.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User getUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getPassword(String password){
        return userRepository.findByPassword(password);
    }
}
