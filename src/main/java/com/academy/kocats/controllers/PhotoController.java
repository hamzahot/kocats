package com.academy.kocats.controllers;


import com.academy.kocats.dao.PhotoDao;
import com.academy.kocats.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/cat-photo")
public class PhotoController {



    @Autowired
    private PhotoService photoService;




    @PostMapping(value = "upload/{id}")
    public ResponseEntity<Void> upload(@RequestParam("photo") MultipartFile multipartFile , @PathVariable("id") Integer id) throws IOException {
        photoService.upload(multipartFile, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable("id") Integer id) throws IOException {
        PhotoDao photoDao = photoService.download(id);
        ByteArrayResource byteArrayResource = new ByteArrayResource(photoDao.getFileBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("FILE_NAME" , photoDao.getName());

        return new ResponseEntity<>(byteArrayResource , httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "get-photos/{id}")
    public ResponseEntity<List<String>> getAllPhotosOfCat(@PathVariable("id") Integer id){
        List<String> photoNames = photoService.getPhotosOfCat(id);
        return new ResponseEntity<>(photoNames, HttpStatus.OK);
    }



}
