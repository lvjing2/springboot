package com.worksap.springboot.dao;

import com.worksap.springboot.dto.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Zhao Zhenling on 2/23/17.
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}
