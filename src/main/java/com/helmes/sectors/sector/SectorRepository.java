package com.helmes.sectors.sector;

import com.helmes.sectors.sector.entity.SectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SectorRepository extends JpaRepository<SectorEntity, UUID> {
    List<SectorEntity> findByParentSectorNull();
}
