package com.mon.projectbase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDTO extends BaseDTO {
    private Long id;

    private String name;
}
