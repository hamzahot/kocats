package com.academy.kocats.dto.user.command;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class UserCreateDTO {


    private String firstName;


    private String lastName;

    private String email;


    private String username;


    private String password;

    private String phoneNumber;

    private Date birthDate;


    //YOU CAN ADD CITY LATER


}
