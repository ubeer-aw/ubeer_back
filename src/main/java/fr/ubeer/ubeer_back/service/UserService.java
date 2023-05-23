package fr.ubeer.ubeer_back.service;

import fr.ubeer.ubeer_back.entity.Brewery;
import fr.ubeer.ubeer_back.entity.Product;
import fr.ubeer.ubeer_back.entity.User;
import fr.ubeer.ubeer_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
