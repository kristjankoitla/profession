package com.helmes.sectors.worker;

import com.helmes.sectors.sector.entity.SectorEntity;
import com.helmes.sectors.sector.SectorService;
import com.helmes.sectors.worker.dto.WorkerRequest;
import com.helmes.sectors.worker.dto.WorkerResponse;
import com.helmes.sectors.worker.entity.WorkerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class WorkerMapper {

    @Autowired
    protected SectorService sectorService;

    @Mapping(target = "sectors", source = "request.sectorIds")
    abstract WorkerEntity entityFrom(WorkerRequest request);

    @Mapping(target = "sectors", source = "request.sectorIds")
    abstract WorkerEntity entityFrom(UUID id, WorkerRequest request);

    @Mapping(target = "sectorIds", source = "entity.sectors")
    abstract WorkerResponse responseFrom(WorkerEntity entity);

    UUID idFromSectorEntity(SectorEntity sectorEntity) {
        return sectorEntity.getId();
    }

    SectorEntity sectorEntityFromId(UUID id) {
        return sectorService.getById(id);
    }
}
