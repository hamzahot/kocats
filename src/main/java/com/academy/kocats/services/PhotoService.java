package com.academy.kocats.services;


import com.academy.kocats.dao.PhotoDao;
import com.academy.kocats.entities.Cat;
import com.academy.kocats.entities.CatPhoto;
import com.academy.kocats.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class PhotoService {



    @Value("${fs.base-Url}")
    private String baseFilePath;


    @Autowired
    private PhotoRepository photoRepository;

    public void upload(MultipartFile multipartFile, Integer id) throws IOException {

        String originalName = new Date().getTime() + "_" +  multipartFile.getOriginalFilename();

        String fullPath = baseFilePath + originalName;
        Path path = Paths.get(fullPath);
        Files.write(path, multipartFile.getBytes());

        CatPhoto catPhoto = new CatPhoto();
        catPhoto.setName(originalName);
        catPhoto.setFullPath(fullPath);

        Cat cat = new Cat();
        cat.setCatId(id);
        catPhoto.setCat(cat);

        photoRepository.save(catPhoto);
    }

    public PhotoDao download(Integer id) throws IOException {

        String fullPath = photoRepository.fullPathById(id);
        String name = photoRepository.nameById(id);


        Path path = Paths.get(fullPath);
        return new PhotoDao(Files.readAllBytes(path), name);


    }

    public List<String> getPhotosOfCat(Integer id) {
        return photoRepository.getAllWithId(id);
    }
}
