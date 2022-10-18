package com.helmes.sectors.worker;

import com.helmes.sectors.worker.dto.WorkerRequest;
import com.helmes.sectors.worker.dto.WorkerResponse;
import com.helmes.sectors.worker.entity.WorkerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService service;
    private final WorkerMapper mapper;

    @PostMapping
    public WorkerResponse postWorker(@RequestBody @Valid WorkerRequest request) {
        WorkerEntity requestEntity = mapper.entityFrom(request);
        WorkerEntity responseEntity = service.saveWorker(requestEntity);
        return mapper.responseFrom(responseEntity);
    }

    @PutMapping("{id}")
    public WorkerResponse putWorker(@PathVariable UUID id, @RequestBody @Valid WorkerRequest request) {
        WorkerEntity requestEntity = mapper.entityFrom(id, request);
        WorkerEntity responseEntity = service.saveWorker(requestEntity);
        return mapper.responseFrom(responseEntity);
    }
}
