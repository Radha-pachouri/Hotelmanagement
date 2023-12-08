package com.geekster.hotelManagement.controller;

import com.geekster.hotelManagement.dto.SignInInput;
import com.geekster.hotelManagement.dto.SignInOutput;
import com.geekster.hotelManagement.dto.SignUpInput;
import com.geekster.hotelManagement.dto.SignUpOutput;
import com.geekster.hotelManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }
}
