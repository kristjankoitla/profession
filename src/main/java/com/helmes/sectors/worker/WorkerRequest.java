package com.helmes.sectors.worker;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class WorkerRequest {
    private String name;
    private boolean agreeToTerms;
    List<UUID> sector_ids;
}