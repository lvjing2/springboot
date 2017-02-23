package com.worksap.springboot.service;

import com.worksap.springboot.dao.RoleDao;
import com.worksap.springboot.dao.UserDao;
import com.worksap.springboot.dto.Role;
import com.worksap.springboot.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by Zhao Zhenling on 2/23/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        User user1 = new User();
        user1.setUserName(user.getUserName());
        user1.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
        user1.setRoles(new HashSet<>(roleDao.findAll()));
        userDao.save(user1);
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findUserByName(userName);
    }
}
