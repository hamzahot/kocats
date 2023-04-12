package com.academy.kocats.dto.cat.command;

import com.academy.kocats.dto.race.CatRaceDTO;
import lombok.Data;

import java.util.Set;


@Data
public class CatUpdateDTO {


    private Integer catId;
    private String name;
    private Set<CatRaceDTO> breeds;



}
