package spharos.client.service.domain.worker;

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

    @Column(nullable = false, length = 20, name = "worker_id")
    private Long workerId;

    @Column(nullable = false, length = 20, name = "reservation_id")
    private Long reservationId;

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

    public WorkerReservationHistory(Long workerId,
                                    Long reservationId,
                                    LocalDate reservationDate,
                                    LocalTime startTime,
                                    LocalTime endTime,
                                    Integer serviceTime) {
        this.workerId = workerId;
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.serviceTime = serviceTime;
    }

    public static WorkerReservationHistory createWorkerReservationHistory(Long workerId,
                                                                          Long reservationId,
                                                                          LocalDate reservationDate,
                                                                          LocalTime startTime,
                                                                          LocalTime endTime,
                                                                          Integer serviceTime) {
        return new WorkerReservationHistory(workerId, reservationId, reservationDate, startTime, endTime, serviceTime);
    }
}
