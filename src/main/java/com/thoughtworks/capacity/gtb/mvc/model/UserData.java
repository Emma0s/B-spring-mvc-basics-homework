package com.thoughtworks.capacity.gtb.mvc.model;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class UserData {
    private static final Map<Integer, User> userMap = new HashMap<>();
    private static Integer count = 1;
    public static Map<Integer, User> getUserData() {
        return userMap;
    }

    private static void initUsers(){
        userMap.put(count++, new User("wenwei","12345","wenwei@qq.com"));
        userMap.put(count++, new User("wenwei2","12345","wenwei@qq.com"));
    }

    public static void addUser(User user) {
        userMap.put(count++, user);
    }
}
