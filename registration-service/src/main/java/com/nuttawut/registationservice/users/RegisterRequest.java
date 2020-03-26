package com.nuttawut.registationservice.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private String address;
    private String phone;
    private Integer salary;
}
