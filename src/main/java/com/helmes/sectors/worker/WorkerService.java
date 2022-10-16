package com.helmes.sectors.worker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerDao dao;

    public WorkerEntity saveWorker(WorkerEntity worker) {
        return dao.save(worker);
    }
}
