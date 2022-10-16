package com.helmes.sectors.worker;

import com.helmes.sectors.sector.SectorEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "worker")
public class WorkerEntity {

    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "agree_to_term")
    private boolean agreeToTerms;

    @ManyToMany
    @JoinTable(
            name = "sector_worker",
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "sector_id"))
    List<SectorEntity> sectors;
}
