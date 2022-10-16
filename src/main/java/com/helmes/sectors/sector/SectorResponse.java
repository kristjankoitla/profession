package com.helmes.sectors.sector;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class SectorResponse {
    private UUID id;
    private String name;
    private List<SectorResponse> subSectors;
}
