package com.worksap.springboot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Value;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Zhao Zhenling on 2/23/17.
 */
@Data
@Getter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
