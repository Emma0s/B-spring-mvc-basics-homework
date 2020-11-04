package com.thoughtworks.capacity.gtb.mvc.dto;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private int id;
    private User user;

    public UserDTO(int id, User user) {
        this.id = id;
        this.user = user;
    }
}
