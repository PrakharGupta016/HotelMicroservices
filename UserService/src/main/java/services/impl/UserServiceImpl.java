package services.impl;

import entities.User;
import exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import services.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
        {
            throw new ResourceNotFoundException("user with " + userId + "not found");
        }
        return user.get();
    }

    @Override
    public void deteleUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
        {
            throw new ResourceNotFoundException("user with " + userId + "not found");
        }
        userRepository.delete(user.get());
    }


}
