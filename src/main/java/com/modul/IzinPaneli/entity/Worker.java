package com.modul.IzinPaneli.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "worker_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"workerId"})
public class Worker implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_worker_info", allocationSize = 1)
    @GeneratedValue(generator = "seq_worker_info", strategy = GenerationType.SEQUENCE)
    private long workerId;
    @Column(name = "firstName", length = 100)
    private String firstName;
    @Column(name = "lastName", length = 100)
    private String lastName;

    @Column(name = "izinDurum", length = 50)
    private String izinDurum;

    @OneToMany
    @JoinColumn(name = "worker_leave_id")
    private List<WorkerLeaveInfo> izinBilgileri;


}
