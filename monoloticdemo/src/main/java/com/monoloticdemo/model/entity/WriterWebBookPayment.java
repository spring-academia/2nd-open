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
public class WriterWebBookPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long writerWebBookPayment;

    private Long webBookChapterId;

    private Long readerWebBookPaymentId;

    private Integer paymentAmount;

    private boolean isWithdraw; //default = false;

    private LocalDateTime createdAt;

}
