package com.bms.central_api_v1.controller;


import com.bms.central_api_v1.requestdto.CreateUserDb;
import com.bms.central_api_v1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/central/user")

@Slf4j

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")

    public Object registerUser(@RequestBody CreateUserDb createUserDb){

        log.info("Request body received from the client");

        return userService.registerUser(createUserDb);

    }
}
