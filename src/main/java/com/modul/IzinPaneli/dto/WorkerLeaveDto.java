package com.modul.IzinPaneli.dto;

import com.modul.IzinPaneli.entity.Worker;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class WorkerLeaveDto {
    private long workerId;
    private int usedLeaveDay;
    private int leaveDay;
    private Worker worker;
}
