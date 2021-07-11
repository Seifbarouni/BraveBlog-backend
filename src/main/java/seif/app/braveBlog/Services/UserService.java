package seif.app.braveBlog.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seif.app.braveBlog.Data.PostsRepository;
import seif.app.braveBlog.Data.UserRepository;
import seif.app.braveBlog.Models.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostsRepository postsRepository;

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public String updateUser(String oldUsername, String username, String email, String imgUrl) {
        Optional<User> opUs = userRepository.findByUsername(oldUsername);
        if (opUs.isPresent()) {
            User us = opUs.get();
            us.setUsername(username);
            us.setEmail(email);
            us.setPicUrl(imgUrl);
            us = userRepository.save(us);
            postsRepository.updatePosts(username, oldUsername);
            if (us != null)
                return "Success";
        }
        return "Error";
    }
}
