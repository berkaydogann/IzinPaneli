package com.modul.IzinPaneli.service.impl;

import com.modul.IzinPaneli.dto.WorkerDto;
import com.modul.IzinPaneli.entity.Worker;
import com.modul.IzinPaneli.entity.WorkerLeaveInfo;
import com.modul.IzinPaneli.repo.LeaveRepository;
import com.modul.IzinPaneli.repo.WorkerRepository;
import com.modul.IzinPaneli.service.WorkerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;


    @Override
    @Transactional
    public WorkerDto save(WorkerDto workerDto) {

        Worker worker = new Worker();
        worker.setFirstName(workerDto.getFirstName());
        worker.setLastName(workerDto.getLastName());
        worker.setIzinDurum(workerDto.getIzinDurum());
        worker.setUsedLeaveDay(workerDto.getUsedLeaveDay());
        worker.setLeaveDay(workerDto.getLeaveDay());
        Worker workerDb = workerRepository.save(worker);

        workerDto.setWorkerId(workerDb.getWorkerId());
        return workerDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<WorkerDto> getAll() {
        List<Worker> workers = workerRepository.findAll();
        List<WorkerDto> workerDtos = new ArrayList<>();
        workers.forEach(it -> {
            WorkerDto workerDto = new WorkerDto();
            workerDto.setWorkerId(it.getWorkerId());
            workerDto.setFirstName(it.getFirstName());
            workerDto.setLastName(it.getLastName());
            workerDto.setIzinDurum(it.getIzinDurum());
            workerDto.setUsedLeaveDay(it.getUsedLeaveDay());
            workerDto.setLeaveDay(it.getLeaveDay());
            workerDtos.add(workerDto);
        });
        return workerDtos;
    }

    @Override
    public void update(Long id) {

    }
}
