package com.env.gs.service.implementation;

import com.env.gs.domain.User;
import com.env.gs.repository.UserRepository;
import com.env.gs.request.UserCreateRequest;
import com.env.gs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByName(String email) {
        User user = userRepository.getUserByName(email);
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User addUser(UserCreateRequest request) {
        User user = new User();
        Random random = new Random();
        int id= random.nextInt();
        user.setUserId(id);
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRoleId(request.getRoleId());

        return userRepository.save(user);
    }
}
