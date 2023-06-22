package com.mon.projectbase.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO extends BaseDTO {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private Set<RoleDTO> roles;
}