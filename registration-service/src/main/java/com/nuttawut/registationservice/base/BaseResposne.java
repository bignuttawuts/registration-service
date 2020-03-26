package com.nuttawut.registationservice.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResposne {
    private String status = "success";
    private String errorCode;
    private String message;
}
