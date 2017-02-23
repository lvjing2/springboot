package com.worksap.springboot.validator;

import com.worksap.springboot.dto.User;
import com.worksap.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Zhao Zhenling on 2/23/17.
 */
@Component
public class UserValidator implements Validator{
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
            errors.rejectValue("userName", "Size.userForm.userName");
        }
        if (userService.findByUserName(user.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.userName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passWord", "NotEmpty");
        if (user.getPassWord().length() < 8 || user.getPassWord().length() > 32) {
            errors.rejectValue("passWord", "Size.userForm.passWord");
        }
        if (!user.getPassWord().equals(user.getRePassWord())) {
            errors.rejectValue("passWordConfirm", "Diff.userForm.passWordConfirm");
        }
    }
}
