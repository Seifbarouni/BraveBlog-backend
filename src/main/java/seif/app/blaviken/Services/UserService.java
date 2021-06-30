package seif.app.blaviken.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seif.app.blaviken.Data.UserRepository;
import seif.app.blaviken.Models.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
