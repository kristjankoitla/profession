package com.helmes.sectors.worker;

import com.helmes.sectors.worker.entity.WorkerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository repository;

    public WorkerEntity saveWorker(WorkerEntity worker) {
        return repository.save(worker);
    }
}
