package com.academy.kocats.services;


import com.academy.kocats.dto.role.RoleDTO;
import com.academy.kocats.entities.Role;
import com.academy.kocats.mappers.RoleMapper;
import com.academy.kocats.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    public void save(RoleDTO roleDTO) {
        Role role = roleMapper.toEntity(roleDTO);
        roleRepository.save(role);
    }

    public void update(Integer id, RoleDTO roleDTO) {

        roleDTO.setRoleId(id);
        save(roleDTO);
    }

    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public RoleDTO findById(Integer id)
    {
        Role role = roleRepository.findById(id).orElse(null);
        return roleMapper.toDTO(role);
    }

    public List<RoleDTO> findAll(){
        return roleRepository.findAll().stream().map(roleMapper :: toDTO).toList();
    }
}
