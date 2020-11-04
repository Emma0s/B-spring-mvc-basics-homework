package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFindException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
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
        for (User userExist : userMap.values()){
            if(userExist.getUsername().equals(user.getUsername()))
                throw new UserNotFindException("用户名已存在");
        }
        UserData.addUser(user);
        userMap = UserData.getUserData();
    }

    public User login(String username, String password) throws UserNotFindException {
        for (User user : userMap.values()) {
            if (user.getUsername().equals(username)&&user.getPassword().equals(password))
                return user;
        }
        throw new UserNotFindException("用户名或密码错误");
    }

    public Integer findIdByUser(User user) throws UserNotFindException {
        for (int key : userMap.keySet()){
            if (userMap.get(key).equals(user)){
                return key;
            }
        }
        throw new UserNotFindException("该用户不存在");
    }
}
