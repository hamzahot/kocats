package com.academy.kocats.security.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {

    private String username;
    private String password;
    private boolean rememberMe; // false

}
