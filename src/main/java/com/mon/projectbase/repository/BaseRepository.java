package com.mon.projectbase.repository;

import com.mon.projectbase.model.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> {

}
