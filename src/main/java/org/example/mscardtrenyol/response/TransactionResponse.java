package org.example.mscardtrenyol.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import org.example.mscardtrenyol.enums.Currency;
import org.example.mscardtrenyol.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionResponse {

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
