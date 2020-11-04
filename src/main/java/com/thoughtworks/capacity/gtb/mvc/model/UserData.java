package com.thoughtworks.capacity.gtb.mvc.model;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
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

    public static void addUser(User user) {
        userMap.put(count++, user);
    }
}
