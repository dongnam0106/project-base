package com.mon.projectbase.service;

import com.mon.projectbase.dto.ExampleDTO;
import com.mon.projectbase.model.ExampleEntity;
import com.mon.projectbase.repository.ExampleRepository;

import java.util.List;
import java.util.Optional;

public class ExampleService extends BaseService<ExampleRepository, ExampleDTO, ExampleEntity>{
    @Override
    public ExampleDTO create(ExampleDTO dto) {
        return null;
    }

    @Override
    public ExampleDTO update(ExampleDTO dto) {
        return null;
    }

    @Override
    public Optional<ExampleDTO> getDetails(Long id) {
        return Optional.empty();
    }

    @Override
    public ExampleDTO delete(ExampleDTO dto) {
        return null;
    }

    @Override
    public String getEntityName() {
        return null;
    }

    @Override
    public List<ExampleDTO> findAll() {
        return null;
    }
}
