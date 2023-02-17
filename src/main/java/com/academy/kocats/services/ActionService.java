package com.academy.kocats.services;


import com.academy.kocats.dto.action.command.ActionCreateDTO;
import com.academy.kocats.dto.action.query.ActionQueryDTO;
import com.academy.kocats.entities.Action;
import com.academy.kocats.entities.ServiceType;
import com.academy.kocats.mappers.ActionMapper;
import com.academy.kocats.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private ActionMapper actionMapper;

    public void insert(ActionCreateDTO actionCreateDTO) {

        Action action = actionMapper.toEntity(actionCreateDTO);
        ServiceType serviceType = new ServiceType();
        serviceType.setPrice(actionCreateDTO.getPrice());
        serviceType.setCategory("action");

        action.setServiceType(serviceType);

        actionRepository.save(action);

    }

    public List<ActionQueryDTO> getAll() {
        return actionRepository.getAll().stream().map(actionMapper :: toActionQueryDTO).toList();
    }

    public ActionQueryDTO getById(Integer id) {
        return actionMapper.toActionQueryDTO(actionRepository.getById(id));
    }


    public void deleteById(Integer id) {
        actionRepository.deleteById(id);
    }
}
