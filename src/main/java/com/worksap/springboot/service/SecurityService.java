package com.worksap.springboot.service;

/**
 * Created by Zhao Zhenling on 2/23/17.
 */
public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String userName, String passWord);
}
