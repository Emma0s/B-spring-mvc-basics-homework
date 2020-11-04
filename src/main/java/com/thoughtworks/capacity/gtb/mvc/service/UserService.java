package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.model.UserData;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private Map<Integer,User> userMap;

    public UserService() {
        userMap = UserData.getUserData();
    }

    public void register(User user) {
        UserData.addUser(user);
        userMap = UserData.getUserData();
    }
}
