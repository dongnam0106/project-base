package com.mon.projectbase.controller;

import com.mon.projectbase.dto.BaseDTO;
import com.mon.projectbase.service.BaseService;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
public abstract class BaseController<Service extends BaseService<?, DTO, ?>, DTO extends BaseDTO> {

    @Autowired
    protected Service service;

    @Value("${jhipster.clientApp.name}")
    protected String applicationName;

    @PostMapping(value = {"", "/"})
    public ResponseEntity<DTO> create(@Validated(BaseDTO.Create.class) @RequestBody DTO dto)
            throws URISyntaxException {

        DTO result = (DTO) service.create(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = {"/{code}", "/{code}/"})
    public ResponseEntity<DTO> update(@PathVariable Long code,
                                      @Validated(BaseDTO.Update.class) @RequestBody DTO dto) throws URISyntaxException {
        DTO result = (DTO) service.update(dto);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, getEntityName(),
                result.getClass().toString())).body(result);
    }

    @GetMapping(value = {"/{code}", "/{code}/"})
    public ResponseEntity<DTO> getDetails(@PathVariable Long code) {
        Optional<DTO> categoryDTO = service.getDetails(code);
        return ResponseUtil.wrapOrNotFound(categoryDTO);
    }

    public abstract String getEntityName();
}
