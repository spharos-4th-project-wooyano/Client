package spharos.client.worker.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Table(name = "worker_reservation_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WorkerReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, name = "reservation_id")
    private Long reservationId;

    @Column(nullable = false, length = 30, name = "reservation_num")
    private String reservationNum;

    @Column(nullable = false, length = 20, name = "reservation_date")
    private LocalDate reservationDate;

    @Column(nullable = false, length = 20, name = "start_time")
    private LocalTime startTime;

    @Column(nullable = false, length = 20, name = "end_time")
    private LocalTime endTime;

    @Column(nullable = false, length = 20, name = "service_time")
    private Integer serviceTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Worker worker;


    public WorkerReservationHistory(Long id,
                                    Long reservationId,
                                    String reservationNum,
                                    LocalDate reservationDate,
                                    LocalTime startTime,
                                    LocalTime endTime,
                                    Integer serviceTime,
                                    Worker worker) {
        this.id = id;
        this.reservationId = reservationId;
        this.reservationNum = reservationNum;
        this.reservationDate = reservationDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.serviceTime = serviceTime;
        this.worker = worker;
    }

    public static WorkerReservationHistory createWorkerReservationHistory(Long id,
                                                                            Long reservationId,
                                                                            LocalDate reservationDate,
                                                                            String reservationNum,
                                                                            LocalTime startTime,
                                                                            LocalTime endTime,
                                                                            Integer serviceTime,
                                                                            Worker worker) {
        return new WorkerReservationHistory(id,reservationId, reservationNum, reservationDate, startTime, endTime, serviceTime,worker);
    }
}
