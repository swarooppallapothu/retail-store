package com.inmar.retailstore.service.impl;

import com.inmar.retailstore.entities.User;
import com.inmar.retailstore.repository.UserRepository;
import com.inmar.retailstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.getByUsername(username);
    }
}
