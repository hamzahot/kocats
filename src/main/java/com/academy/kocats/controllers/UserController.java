package com.academy.kocats.controllers;

import com.academy.kocats.dto.user.command.UserCreateDTO;
import com.academy.kocats.dto.user.query.UserGetDTO;
import com.academy.kocats.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping(value = "{id}")
    public ResponseEntity<UserGetDTO> getById(@PathVariable("id") Integer id){
        UserGetDTO userGetDTO = userService.getById(id);
        return new ResponseEntity<>(userGetDTO, HttpStatus.OK);
    }

//    @GetMapping(value = "wp/{id}")
//    public ResponseEntity<UserGetDTO> getByIdWithPurchase(@PathVariable("id") Integer id){
//        UserGetDTO userGetDTO = userService.getByIdWp(id);
//        return new ResponseEntity<>(userGetDTO, HttpStatus.OK);
//    }


    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserCreateDTO userCreateDTO){
        userService.insert(userCreateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id , @RequestBody UserCreateDTO userCreateDTO){
        if(userCreateDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.update(id, userCreateDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
