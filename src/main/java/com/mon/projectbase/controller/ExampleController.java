package com.mon.projectbase.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itextpdf.text.DocumentException;
import com.mon.projectbase.dto.ExampleDTO;
import com.mon.projectbase.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/example")
public class ExampleController extends BaseController<ExampleService, ExampleDTO> {
    @Autowired
    ExampleService exampleService;

    @PostMapping("/pdf")
    public ResponseEntity exportTicketPDFFile()
            throws DocumentException, JsonProcessingException {

        ByteArrayInputStream arrayInputStream = exampleService.exportPdf();

        InputStreamResource file = new InputStreamResource(arrayInputStream);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(file);
    }
}
