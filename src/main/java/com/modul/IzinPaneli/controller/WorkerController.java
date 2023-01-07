package com.modul.IzinPaneli.controller;

import com.modul.IzinPaneli.dto.WorkerDto;
import com.modul.IzinPaneli.entity.Worker;
import com.modul.IzinPaneli.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor

public class WorkerController {
    private final WorkerService workerService;

    @PostMapping
    public ResponseEntity<WorkerDto> save(@RequestBody WorkerDto workerDto) {
        return ResponseEntity.ok(workerService.save(workerDto));
    }

    @GetMapping
    public ResponseEntity<List<WorkerDto>> listAll() {
        return ResponseEntity.ok(workerService.getAll());
    }

}
