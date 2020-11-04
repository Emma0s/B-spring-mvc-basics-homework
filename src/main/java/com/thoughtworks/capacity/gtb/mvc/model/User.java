package com.thoughtworks.capacity.gtb.mvc.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull(message = "用户名不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,10}$",message = "用户名不合法")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^[0-9]{5,12}$",message = "密码不合法")
    private String password;

    @Email(message = "邮箱地址不合法")
    private String email;
}
