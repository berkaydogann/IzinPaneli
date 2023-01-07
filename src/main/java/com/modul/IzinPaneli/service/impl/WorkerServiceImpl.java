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
    private final LeaveRepository leaveRepository;

    @Override
    @Transactional
    public WorkerDto save(WorkerDto workerDto) {
        //Assert.isNull(workerDto.getFirstName(), "Adi Alani zorunludur!");
        Worker worker = new Worker();
        worker.setFirstName(workerDto.getFirstName());
        worker.setLastName(workerDto.getLastName());
        worker.setIzinDurum(workerDto.getIzinDurum());
        Worker workerDb = workerRepository.save(worker);
       /* List<WorkerLeaveInfo> liste = new ArrayList<>();
        workerDto.getIzinBilgileri().forEach(item -> {
            WorkerLeaveInfo workerLeaveInfo = new WorkerLeaveInfo();
            workerLeaveInfo.setLeaveDay(5);
            workerLeaveInfo.setUsedLeaveDay(0);
            liste.add(workerLeaveInfo);
        });
        leaveRepository.saveAll(liste);*/
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
            workerDto.setIzinDurum(it.getIzinBilgileri().stream().map(WorkerLeaveInfo::getWorker)
                    .collect(Collectors.toList()).toString());
            workerDtos.add(workerDto);
        });
        return workerDtos;
    }

    @Override
    public void update(Long id) {

    }
}
