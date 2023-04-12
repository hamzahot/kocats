package com.academy.kocats.dto.cat.query;

import com.academy.kocats.dto.race.CatRaceDTO;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CatGetDTO {

    private Integer catId;
    private String name;
    private Set<CatRaceDTO> breeds;
    private Integer yearBorn;
    private String gender;
    private List<String> photos;
    private Boolean isSterilized;

}
