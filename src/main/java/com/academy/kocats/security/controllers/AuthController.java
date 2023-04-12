package com.academy.kocats.security.controllers;

import com.academy.kocats.dto.user.command.UserCreateDTO;
import com.academy.kocats.security.dto.LoginDTO;
import com.academy.kocats.security.dto.TokenDTO;
import com.academy.kocats.security.jwt.JwtTokenProvider;
import com.academy.kocats.security.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authenticate")
public class AuthController {

    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenticationManagerBean;

    private final AuthService authService;



    // authentication flow!
    @PostMapping(value = "login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO)
    {
        try
        {
            Authentication authData = new UsernamePasswordAuthenticationToken(
                    loginDTO.getUsername(), loginDTO.getPassword() // client password | User (Spring Security Code -> DB password)
            );
            Authentication authentication = authenticationManagerBean.authenticate(authData);

            // username
            // password
            // authorities (role)
            SecurityContextHolder.getContext().setAuthentication(authentication); // context holder filled!

            TokenDTO tokenDTO = tokenProvider.generateToken(authentication, loginDTO.isRememberMe());
            return new ResponseEntity<>(tokenDTO, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Bad credentials!");
            response.put("exceptionMessage", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }




    @PostMapping(value = "register")
    public ResponseEntity<Void> register(@RequestBody UserCreateDTO userCreateDTO)  {

//        Errors validationErrors = new BeanPropertyBindingResult(userCommandDTO, "userCommandDTO");
//        ValidationUtils.invokeValidator(userRegisterCommandDTOValidator, userCommandDTO, validationErrors);
//
//        if(validationErrors.hasErrors()){
//            throw new CustomValidationException(validationErrors);
//        }


        authService.save(userCreateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}
