package com.mon.projectbase.repository;

import com.mon.projectbase.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends BaseRepository<Role>, JpaRepository<Role, Long> {
    Role findByName(String name);
}
