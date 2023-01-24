package com.academy.kocats.controllers;

import com.academy.kocats.dto.user.command.UserCreateDTO;
import com.academy.kocats.dto.user.query.UserGetDTO;
import com.academy.kocats.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping(value = "all")
    public ResponseEntity<List<UserGetDTO>> getAll(){
        List<UserGetDTO> userGetDTOS = userService.getAll();
        return new ResponseEntity<>(userGetDTOS, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Void> insert(@RequestBody UserCreateDTO userCreateDTO){
        userService.insert(userCreateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
