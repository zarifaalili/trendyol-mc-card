package org.example.mscardtrenyol.model.response;

import lombok.Builder;
import lombok.Data;
import org.example.mscardtrenyol.model.enums.Currency;
import org.example.mscardtrenyol.model.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionResponse {

    private BigDecimal amount;

    private Currency currency;

    private Status status;

    private LocalDateTime transactionDate;

    private String providerResponse;

    private String sender;

    private String  receiver;
}
