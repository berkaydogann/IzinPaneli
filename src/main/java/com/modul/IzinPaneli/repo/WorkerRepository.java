package com.modul.IzinPaneli.repo;

import com.modul.IzinPaneli.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
