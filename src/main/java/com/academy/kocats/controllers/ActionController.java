package com.academy.kocats.controllers;


import com.academy.kocats.dto.action.command.ActionCreateDTO;
import com.academy.kocats.dto.action.command.ActionUpdateDTO;
import com.academy.kocats.dto.action.query.ActionQueryDTO;
import com.academy.kocats.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/action")
public class ActionController {


    @Autowired
    private ActionService actionService;


    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ActionCreateDTO actionCreateDTO){
        actionService.insert(actionCreateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody ActionUpdateDTO actionUpdateDTO){
        actionService.update(actionUpdateDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ActionQueryDTO>> getAll(){
        List<ActionQueryDTO> list = actionService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ActionQueryDTO> getById(@PathVariable("id") Integer id){
        ActionQueryDTO actionQueryDTO = actionService.getById(id);
        return new ResponseEntity<>(actionQueryDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        actionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
