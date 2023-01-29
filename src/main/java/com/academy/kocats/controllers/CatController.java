package com.academy.kocats.controllers;


import com.academy.kocats.dto.cat.command.CatCreateDTO;
import com.academy.kocats.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cat")
public class CatController {

    @Autowired
    private CatService catService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CatCreateDTO catCreateDTO){
        catService.insert(catCreateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(value = "{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody CatCreateDTO catCreateDTO){
        if(catCreateDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catService.update(id, catCreateDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        catService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
