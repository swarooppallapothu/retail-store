package com.inmar.retailstore.service;

import com.inmar.retailstore.entities.User;

/**
 * Created by Swaroop Pallapothu on Jul, 2019
 */
public interface UserService {

    User findByUserName(String username);
}
