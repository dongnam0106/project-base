package com.mon.projectbase.controller;

import com.mon.projectbase.dto.ExampleDTO;
import com.mon.projectbase.service.ExampleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController extends BaseController<ExampleService, ExampleDTO> {
}
