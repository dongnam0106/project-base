package com.mon.projectbase.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "example")
public class ExampleEntity extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
}
