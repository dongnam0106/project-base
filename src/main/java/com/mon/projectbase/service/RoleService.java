package com.mon.projectbase.service;

import com.mon.projectbase.dto.RoleDTO;
import com.mon.projectbase.model.Role;
import com.mon.projectbase.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService extends BaseService<RoleRepository, RoleDTO, Role> {
    @Autowired
    private RoleRepository repository;

    @Override
    public RoleDTO create(RoleDTO dto) {
        return null;
    }

    @Override
    public RoleDTO update(RoleDTO dto) {
        return null;
    }

    @Override
    public Optional<RoleDTO> getDetails(Long id) {
        return Optional.empty();
    }

    @Override
    public RoleDTO delete(RoleDTO dto) {
        return null;
    }

    @Override
    public List<RoleDTO> findAll() {
        return null;
    }

    public Optional<Role> findById(Long id) {
        return repository.findById(id);
    }

    public Role findByName(String name) {
        return repository.findByName(name);
    }

}
