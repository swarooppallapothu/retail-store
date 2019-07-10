package com.inmar.retailstore.config;

import com.inmar.retailstore.entities.User;
import com.inmar.retailstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DataLoader(UserRepository userRepository,
                      BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void run(ApplicationArguments args) {
        User user = userRepository.getByUsername("superadmin");
        if (user == null) {
            User entity = new User();
            entity.setUsername("superadmin");
            entity.setPassword(bCryptPasswordEncoder.encode("passme"));
            userRepository.save(entity);
        }
    }
}
