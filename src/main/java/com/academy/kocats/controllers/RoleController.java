package com.academy.kocats.controllers;


import com.academy.kocats.dto.role.RoleDTO;
import com.academy.kocats.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {


    @Autowired
    private RoleService roleService;



    @PostMapping // body -> ?
    public ResponseEntity<Void> insert(@RequestBody RoleDTO roleDTO)
    {
        if (roleDTO.getRoleId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        roleService.save(roleDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Void> update(@RequestBody RoleDTO roleDTO)
    {
        if (roleDTO.getRoleId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        roleService.save(roleDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Void> updateWithId(@PathVariable Integer id, @RequestBody RoleDTO roleDTO)
    {
        roleService.update(id, roleDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id)
    {
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<RoleDTO> byId(@PathVariable Integer id)
    {
        RoleDTO roleDTO = roleService.findById(id);
        return new ResponseEntity<>(roleDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> all(){
        List<RoleDTO> list = roleService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
