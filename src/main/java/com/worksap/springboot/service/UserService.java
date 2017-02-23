package com.worksap.springboot.service;

import com.worksap.springboot.dto.User;

/**
 * Created by Zhao Zhenling on 2/23/17.
 */
public interface UserService {
    void save(User user);
    User findByUserName(String userName);
}
