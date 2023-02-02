package com.mon.projectbase.repository;

import com.mon.projectbase.model.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends BaseRepository<ExampleEntity>, JpaRepository<ExampleEntity, Long> {
}
