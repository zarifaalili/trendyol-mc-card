package org.example.mscardtrenyol.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.mscardtrenyol.enums.Currency;
import org.example.mscardtrenyol.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "payment_transactions")
@Builder
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Integer transactionId;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime transactionDate;

    private String providerResponse;


    private String sender;

    private String receiver;



}
