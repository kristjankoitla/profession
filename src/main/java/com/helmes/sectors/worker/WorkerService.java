package com.helmes.sectors.worker;

import com.helmes.sectors.worker.entity.WorkerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository repository;

    public WorkerEntity saveWorker(WorkerEntity worker) {
        return repository.save(worker);
    }

    public WorkerEntity getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Worker does not exist"));
    }
}
