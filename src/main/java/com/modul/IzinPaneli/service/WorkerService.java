package com.modul.IzinPaneli.service;

import com.modul.IzinPaneli.dto.WorkerDto;

import java.util.List;

public interface WorkerService {
    WorkerDto save(WorkerDto workerDto);

    void delete(Long id);

    List<WorkerDto> getAll();

    void update(Long id);
}
