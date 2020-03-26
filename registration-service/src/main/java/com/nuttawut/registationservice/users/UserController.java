package com.nuttawut.registationservice.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse responseBody = null;
        try {
            responseBody = userService.createUser(registerRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
        } catch (Exception ex) {
            responseBody.setStatus("error");
            responseBody.setErrorCode("ERR-001");
            responseBody.setMessage("ERR-001");
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        }
    }

}
