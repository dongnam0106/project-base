package com.mon.projectbase.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "example")
public class ExampleEntity extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
