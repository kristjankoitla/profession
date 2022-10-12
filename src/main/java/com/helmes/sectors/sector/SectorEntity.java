package com.helmes.sectors.sector;

import com.helmes.sectors.worker.WorkerEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "sector")
public class SectorEntity {

    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "sectors")
    Set<WorkerEntity> workers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_sector_id")
    private SectorEntity parentSector;

    @OneToMany(mappedBy = "parentSector")
    private List<SectorEntity> subSectors;
}
