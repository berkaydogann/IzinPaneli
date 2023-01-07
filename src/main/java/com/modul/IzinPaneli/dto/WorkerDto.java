package com.modul.IzinPaneli.dto;

import com.modul.IzinPaneli.entity.WorkerLeaveInfo;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
public class WorkerDto {
    private long workerId;
    private String firstName;
    private String lastName;
    private String izinDurum;
    //private List<WorkerLeaveInfo> izinBilgileri;
}
