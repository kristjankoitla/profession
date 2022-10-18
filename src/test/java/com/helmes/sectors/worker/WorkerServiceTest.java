package com.helmes.sectors.worker;

import com.helmes.sectors.worker.entity.WorkerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WorkerServiceTest {

    private static final UUID ID = UUID.randomUUID();

    private final WorkerRepository repository = mock(WorkerRepository.class);
    private final WorkerService service = new WorkerService(repository);

    private WorkerEntity workerEntity;

    @BeforeEach
    void beforeEach() {
        workerEntity = new WorkerEntity();
        workerEntity.setId(ID);
    }

    @Test
    void saveAndReturn() {
        when(repository.save(workerEntity)).thenReturn(workerEntity);
        WorkerEntity response = service.saveWorker(workerEntity);
        assertEquals(ID, response.getId());
    }
}