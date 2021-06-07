package com.monoloticdemo.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class ReaderWebBookPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long readerWebBookPaymentId;

    private Long webBookChapterId;

    private Long readerId;

    private Integer paymentAmount;

    private LocalDateTime createdAt;


}
