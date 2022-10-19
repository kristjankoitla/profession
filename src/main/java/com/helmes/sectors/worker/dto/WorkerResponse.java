package com.helmes.sectors.worker.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class WorkerResponse {
    private UUID id;
    private String name;
    private boolean agreeToTerms;
    List<UUID> sectorIds;
}
