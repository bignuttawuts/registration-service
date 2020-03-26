package com.nuttawut.registationservice.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private String generateRefCode(Date registerDate, String phoneNumber) {
        String pattern = "yyyyMMdd";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(registerDate);
    }

    private String getMemberType(Integer salary) throws Exception {
        Integer platinumRate = new Integer(50000);
        Integer goldRate = new Integer(30000);
        Integer silverRate = new Integer(15000);

        if (salary.compareTo(platinumRate) > 0) {
            return "Platinum";
        } else if (salary.compareTo(goldRate) > 0) {
            return "Gold";
        } else if (salary.compareTo(silverRate) > 0) {
            return "Silver";
        } else {
            throw new Exception("REG-001");
        }
    }

    public RegisterResponse createUser(RegisterRequest registerRequest) throws Exception {

        UserEntity createUser = new UserEntity();
        createUser.setReferenceCode(generateRefCode(new Date(), registerRequest.getPhone()));
        createUser.setUsername(registerRequest.getUsername());
        createUser.setPassword(registerRequest.getPassword());
        createUser.setAddress(registerRequest.getAddress());
        createUser.setPhone(registerRequest.getPhone());
        createUser.setSalary(registerRequest.getSalary());
        createUser.setMemberType(getMemberType(registerRequest.getSalary()));
        userRepository.save(createUser);

        RegisterResponse response = new RegisterResponse();
        response.setReferenceCode(createUser.getReferenceCode());
        response.setUsername(createUser.getUsername());
        response.setAddress(createUser.getAddress());
        response.setPhone(createUser.getPhone());
        response.setSalary(createUser.getSalary());
        response.setMemberType(createUser.getMemberType());
        return response;
    }
}
