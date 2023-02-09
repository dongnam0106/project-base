package com.mon.projectbase.controller;

import com.mon.projectbase.dto.BaseDTO;
import com.mon.projectbase.service.BaseService;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public abstract class BaseController<Service extends BaseService<?, DTO, ?>, DTO extends BaseDTO> {
    @Autowired
    protected Service service;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<DTO>> getAll() {
        List<DTO> result = service.findAll();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<DTO> create(@Validated(BaseDTO.Create.class) @RequestBody DTO dto) {

        DTO result = service.create(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = {"/{code}", "/{code}/"})
    public ResponseEntity<DTO> update(@PathVariable Long code,
                                      @Validated(BaseDTO.Update.class) @RequestBody DTO dto) {
        DTO result = service.update(dto);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("ApplicationName", false, "EntityName",
                result.getClass().toString())).body(result);
    }

    @GetMapping(value = {"/{code}", "/{code}/"})
    public ResponseEntity<DTO> getDetails(@PathVariable Long code) {
        Optional<DTO> categoryDTO = service.getDetails(code);
        return ResponseUtil.wrapOrNotFound(categoryDTO);
    }

}
