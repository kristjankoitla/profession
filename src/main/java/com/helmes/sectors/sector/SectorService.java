package com.helmes.sectors.sector;

import com.helmes.sectors.sector.entity.SectorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SectorService {

    private final SectorRepository repository;

    public SectorEntity getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sector does not exist"));
    }

    public List<SectorEntity> getAllSectorsHierarchically() {
        return repository.findByParentSectorNull();
    }
}
