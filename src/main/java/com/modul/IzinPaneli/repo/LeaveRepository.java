package com.modul.IzinPaneli.repo;

import com.modul.IzinPaneli.entity.WorkerLeaveInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<WorkerLeaveInfo, Long> {
}
