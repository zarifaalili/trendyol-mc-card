package org.example.mscardtrenyol.request;

import jakarta.persistence.*;
import lombok.Data;
import org.example.mscardtrenyol.entity.Card;
import org.example.mscardtrenyol.enums.Currency;
import org.example.mscardtrenyol.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionRequest {

    private Integer transactionId;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime transactionDate;

    private String providerResponse;

    private String sender;

    private String  receiver;

}
