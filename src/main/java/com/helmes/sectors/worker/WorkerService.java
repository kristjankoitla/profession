package com.helmes.sectors.worker;

import com.helmes.sectors.worker.entity.WorkerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository dao;

    public WorkerEntity saveWorker(WorkerEntity worker) {
        return dao.save(worker);
    }
}
