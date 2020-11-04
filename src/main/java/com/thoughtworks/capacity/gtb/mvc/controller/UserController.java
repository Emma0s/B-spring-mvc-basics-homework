package com.thoughtworks.capacity.gtb.mvc.controller;


import com.thoughtworks.capacity.gtb.mvc.dto.UserDTO;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user) {
        userService.register(user);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO login(@RequestParam(name = "username") String username,
                         @RequestParam(name = "password") String password){
        User user = userService.login(username,password);
        return new UserDTO(userService.findIdByUser(user),user);
    }

}
