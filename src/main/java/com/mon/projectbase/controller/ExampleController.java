package com.mon.projectbase.controller;

import com.mon.projectbase.dto.ExampleDTO;
import com.mon.projectbase.service.ExampleService;

public class ExampleController extends BaseController<ExampleService, ExampleDTO> {
    @Override
    public String getEntityName() {
        return null;
    }
}
