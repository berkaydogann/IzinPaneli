package com.modul.IzinPaneli.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.jdbc.Work;

import java.io.Serializable;

@Entity
@Table(name = "worker_leave_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"workerId"})    //Workerid'ler eşit ise eşleme için kullanılmıştır.
@ToString
public class WorkerLeaveInfo implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_worker_leave_info", allocationSize = 1)
    @GeneratedValue(generator = "seq_worker_leave_info", strategy = GenerationType.SEQUENCE)

    private long workerId;
    @Column(name = "usedLeaveDay", nullable = false)
    private int usedLeaveDay;
    @Column(name = "leaveDay", nullable = false)
    private int leaveDay;

    @OneToOne
    @JoinColumn(name = "worker_leave_id")
    private Worker worker;
}
