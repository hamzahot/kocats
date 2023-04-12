package com.academy.kocats.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhotoDao {

    private byte[] fileBytes;
    private String name;


}
