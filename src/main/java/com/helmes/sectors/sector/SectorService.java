package com.helmes.sectors.sector;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorService {

    private final SectorDao dao;

    public List<SectorEntity> getAllSectorsHierarchically() {
        return dao.findByParentSectorNull();
    }
}
