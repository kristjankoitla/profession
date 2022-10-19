package com.helmes.sectors.worker;

import com.helmes.sectors.worker.entity.WorkerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WorkerServiceTest {

    private static final UUID ID = UUID.randomUUID();

    private final WorkerRepository repository = mock(WorkerRepository.class);
    private final WorkerService service = new WorkerService(repository);

    private WorkerEntity entity;

    @BeforeEach
    void beforeEach() {
        entity = new WorkerEntity();
        entity.setId(ID);
    }

    @Test
    void saveAndReturn() {
        when(repository.save(entity)).thenReturn(entity);
        WorkerEntity response = service.saveWorker(entity);
        assertEquals(ID, response.getId());
    }

    @Test
    void getById_ok() {
        when(repository.findById(ID)).thenReturn(Optional.of(entity));
        WorkerEntity response = service.getById(ID);

        assertEquals(ID, response.getId());
    }

    @Test
    void getById_doesNotExist() {
        when(repository.findById(ID)).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, () -> service.getById(ID));
    }
}