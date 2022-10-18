package com.helmes.sectors.sector;

import com.helmes.sectors.sector.dto.SectorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("sectors")
public class SectorController {

    private final SectorService service;
    private final SectorMapper mapper;

    @GetMapping
    public List<SectorResponse> getAll() {
        return mapper.responseFrom(service.getAllSectorsHierarchically());
    }
}
