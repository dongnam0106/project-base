package com.mon.projectbase.service;

import com.mon.projectbase.dto.BaseDTO;
import com.mon.projectbase.model.BaseEntity;
import com.mon.projectbase.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class BaseService<Repository extends BaseRepository<Entity> & JpaRepository<Entity, ?>, DTO extends BaseDTO, Entity extends BaseEntity> {

    public abstract DTO create(DTO dto);

    public abstract DTO update(DTO dto);

    public abstract Optional<DTO> getDetails(Long id);

    public abstract DTO delete(DTO dto);

    public abstract List<DTO> findAll();

}
