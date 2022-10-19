package com.helmes.sectors.worker.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class WorkerRequest {

    @NotNull
    private String name;

    @NotNull
    private boolean agreeToTerms;
    List<UUID> sectorIds;
}
