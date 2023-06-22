package com.mon.projectbase.repository;

import com.mon.projectbase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User>, JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
}
