package com.worksap.springboot.dao;

import com.worksap.springboot.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Zhao Zhenling on 2/23/17.
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findUserByName(String name);
}
