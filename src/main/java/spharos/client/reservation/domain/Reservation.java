package spharos.client.reservation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spharos.client.global.common.domain.BaseEntity;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private ReservationGoods reservationGoods;
    @Column(nullable = false, length = 50, name = "user_email")
    private String userEmail;
    @Column(nullable = false, name = "service_id")
    private Long serviceId;
    @Column(name = "worker_id")
    private Long workerId;
    @Column(nullable = false, name = "reservation_date")
    private LocalDate reservationDate;
    @Column(nullable = false, name = "service_start")
    private LocalTime serviceStart;
    @Column(nullable = false, name = "service_end")
    private LocalTime serviceEnd;
    @Column(nullable = false)
    @Convert(converter = ReservationStateConverter.class)
    private ReservationState reservationState;
    @Column(nullable = false, name = "payment_amount")
    private Integer paymentAmount;
    @Column(length = 50, name = "cancel_desc")
    private String cancelDesc;
    @Column(length = 100, name = "request")
    private String request;
    @Column(nullable = false, length = 10, name = "reservation_num")
    private String reservationNum;
    @Column(nullable = false, length = 30, name = "address")
    private String address;

    public void changeStatus(ReservationState status) {
        this.reservationState = status;
    }



}
