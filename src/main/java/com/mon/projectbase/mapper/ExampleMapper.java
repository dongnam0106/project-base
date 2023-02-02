package com.mon.projectbase.mapper;

import com.mon.projectbase.dto.ExampleDTO;
import com.mon.projectbase.model.ExampleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ExampleMapper extends EntityMapper<ExampleDTO, ExampleEntity> {
}
