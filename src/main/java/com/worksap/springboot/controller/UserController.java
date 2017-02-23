package com.worksap.springboot.controller;

import com.worksap.springboot.dto.User;
import com.worksap.springboot.service.SecurityService;
import com.worksap.springboot.service.UserService;
import com.worksap.springboot.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zhao Zhenling on 2/23/17.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("userForm") User userFrom, BindingResult bindingResult, Model model) {
        userValidator.validate(userFrom, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(userFrom);
        securityService.autoLogin(userFrom.getUserName(), userFrom.getRePassWord());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (!error.isEmpty()) {
            model.addAttribute("error", "Your userName and passWord is invalid.");
        }
        if (!logout.isEmpty()) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
