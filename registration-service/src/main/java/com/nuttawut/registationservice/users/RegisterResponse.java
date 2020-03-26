package com.nuttawut.registationservice.users;

import com.nuttawut.registationservice.base.BaseResposne;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class RegisterResponse extends BaseResposne {
    private String referenceCode;
    private String username;
    private String address;
    private String phone;
    private String memberType;
    private Integer salary;
}
