package com.helmes.sectors.sector;

import com.helmes.sectors.sector.dto.SectorResponse;
import com.helmes.sectors.sector.entity.SectorEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectorMapper {
    SectorResponse responseFrom(SectorEntity entity);

    List<SectorResponse> responseFrom(List<SectorEntity> entities);
}
