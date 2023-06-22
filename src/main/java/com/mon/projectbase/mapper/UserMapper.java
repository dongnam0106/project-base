package com.mon.projectbase.mapper;

import com.mon.projectbase.dto.UserDTO;
import com.mon.projectbase.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
