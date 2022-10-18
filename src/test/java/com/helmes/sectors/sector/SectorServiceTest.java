package com.helmes.sectors.sector;

import com.helmes.sectors.sector.entity.SectorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SectorServiceTest {

    private static final UUID ID = UUID.randomUUID();
    private final SectorRepository repository = mock(SectorRepository.class);
    private final SectorService service = new SectorService(repository);

    private SectorEntity entity;

    @BeforeEach
    void setUp() {
        entity = new SectorEntity();
        entity.setId(ID);
    }

    @Test
    void getAll() {
        when(repository.findByParentSectorNull()).thenReturn(List.of(entity));
        List<SectorEntity> response = service.getAllSectorsHierarchically();

        assertEquals(1, response.size());
        assertEquals(entity, response.get(0));
    }

    @Test
    void getById_ok() {
        when(repository.findById(ID)).thenReturn(Optional.of(entity));
        SectorEntity response = service.getById(ID);

        assertEquals(ID, response.getId());
    }

    @Test
    void getById_doesNotExist() {
        when(repository.findById(ID)).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, () -> service.getById(ID));
    }
}
