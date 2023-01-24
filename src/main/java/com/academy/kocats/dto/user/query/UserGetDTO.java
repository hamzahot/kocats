package com.academy.kocats.dto.user.query;

import lombok.Data;

import java.util.Date;

@Data
public class UserGetDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String phoneNumber;
    private Date birthDate;

}
