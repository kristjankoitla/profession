package com.helmes.sectors.worker;

import com.helmes.sectors.sector.SectorEntity;
import com.helmes.sectors.sector.SectorService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class WorkerMapper {

    @Autowired
    protected SectorService sectorService;

    @Mapping(target = "sectors", source = "request.sector_ids")
    abstract WorkerEntity entityFrom(WorkerRequest request);

    @Mapping(target = "sectors", source = "request.sector_ids")
    abstract WorkerEntity entityFrom(UUID id, WorkerRequest request);

    @Mapping(target = "sector_ids", source = "entity.sectors")
    abstract WorkerResponse responseFrom(WorkerEntity entity);

    UUID idFromSectorEntity(SectorEntity sectorEntity) {
        return sectorEntity.getId();
    }

    SectorEntity sectorEntityFromId(UUID id) {
        return sectorService.getById(id);
    }
}