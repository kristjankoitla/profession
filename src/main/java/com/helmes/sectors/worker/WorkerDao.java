package com.helmes.sectors.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkerDao extends JpaRepository<WorkerEntity, UUID> {

}
