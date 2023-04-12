package com.academy.kocats.dto.user.command;


import com.academy.kocats.dto.role.RoleDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class UserCreateDTO {


    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private Date birthDate;
    private Set<RoleDTO> roles;



    //YOU CAN ADD CITY LATER


}
