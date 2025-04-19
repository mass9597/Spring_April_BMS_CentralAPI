package com.bms.central_api_v1.controller;


import com.bms.central_api_v1.requestdto.CreateUserDb;
import com.bms.central_api_v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/central/user")

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")

    public void registerUser(@RequestBody CreateUserDb createUserDb){

        userService.registerUser(createUserDb);

    }
}
