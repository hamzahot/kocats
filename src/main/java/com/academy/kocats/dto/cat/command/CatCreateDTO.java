package com.academy.kocats.dto.cat.command;

import com.academy.kocats.dto.photo.PhotoDTO;
import com.academy.kocats.dto.race.CatRaceDTO;
import com.academy.kocats.entities.Race;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CatCreateDTO {


    private String name;
    private Set<Race> breeds;
    private List<PhotoDTO> photos;


    /////////////////////OBAVEZNO DA SE ISPRAVI

}
