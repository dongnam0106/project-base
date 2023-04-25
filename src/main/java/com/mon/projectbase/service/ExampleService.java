package com.mon.projectbase.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.DocumentException;
import com.mon.projectbase.dto.ExampleDTO;
import com.mon.projectbase.mapper.ExampleMapper;
import com.mon.projectbase.model.ExampleEntity;
import com.mon.projectbase.repository.ExampleRepository;
import com.mon.projectbase.service.exportpdf.PdfGenerator;
import com.mon.projectbase.service.exportpdf.ExampleHeader;
import com.mon.projectbase.service.exportpdf.ExamplePdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExampleService extends BaseService<ExampleRepository, ExampleDTO, ExampleEntity> {
    @Autowired
    private ExampleRepository repository;
    @Autowired
    private ExampleMapper mapper;

    @Override
    public ExampleDTO create(ExampleDTO dto) {
        ExampleEntity exampleEntity = mapper.toEntity(dto);
        repository.save(exampleEntity);
        return dto;
    }

    @Override
    public ExampleDTO update(ExampleDTO dto) {
        ExampleEntity exampleEntity = new ExampleEntity();
        mapper.updateFromDTO(dto, exampleEntity);
        repository.save(exampleEntity);
        return dto;
    }

    @Override
    public Optional<ExampleDTO> getDetails(Long id) {
        return Optional.ofNullable(mapper.toDto(repository.findById(id).get()));
    }

    @Override
    public ExampleDTO delete(ExampleDTO dto) {
        return null;
    }

    @Override
    public List<ExampleDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Autowired
    ObjectMapper objectMapper;
    public ByteArrayInputStream exportPdf() throws DocumentException, JsonProcessingException {
        List<ExampleDTO> userTicketDtoLis = findAll();
        String result = objectMapper.writeValueAsString(userTicketDtoLis);
        List<Map<String, Object>> userTicketDtoMaps = objectMapper.readValue(result, new TypeReference<List<Map<String, Object>>>() {
        });
        List<String> subTitles = new ArrayList<>();

        subTitles.add("Subtitle: ");

        PdfGenerator<ExampleHeader> ticketPdf = new ExamplePdf(userTicketDtoMaps, subTitles);

        return ticketPdf.generatePdf();
    }
}
