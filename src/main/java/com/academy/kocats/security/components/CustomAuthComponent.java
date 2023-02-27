package com.academy.kocats.security.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthComponent {



    @Value("${custom-auth.key}")
    private String authKeyFromConfig;


    public boolean hasPermission(String authKey) {
        return authKey.equals(authKeyFromConfig);
    }

}
