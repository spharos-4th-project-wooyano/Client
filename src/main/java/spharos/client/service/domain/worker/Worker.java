package spharos.client.service.domain.worker;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spharos.client.service.domain.services.Services;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, name = "worker_name")
    private String name;

    @Column(nullable = false, length = 20, name = "worker_phone")
    private String phone;

    @Column(nullable = false, length = 50, name = "worker_description")
    private String description;

    @Column(nullable = false, length = 50, name = "worker_img_url")
    private String imgUrl;

    @Column(nullable = false, length = 50, name = "worker_status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Services service;

    public Worker(String name,
                  String phone,
                  String description,
                  String imgUrl,
                  Integer status,
                  Services service) {
        this.name = name;
        this.phone = phone;
        this.description = description;
        this.imgUrl = imgUrl;
        this.status = status;
        this.service = service;
    }

    public static Worker createWorker(String name,
                                      String phone,
                                      String description,
                                      String imgUrl,
                                      Integer status,
                                      Services service) {
        return new Worker(name, phone, description, imgUrl, status, service);
    }
}
