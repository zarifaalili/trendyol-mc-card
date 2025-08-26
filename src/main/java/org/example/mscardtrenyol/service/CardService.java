package org.example.mscardtrenyol.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mscardtrenyol.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public boolean validateCard(String cardNumber, String holderName) {
        return cardRepository.existsByCardNumberAndHolderNameAndIsActive(cardNumber, holderName, true);
    }

    public boolean simpleValidateCard(String cardNumber) {
        return cardRepository.existsByCardNumberAndIsActive(cardNumber, true);
    }

    public String getHolderName(String cardNumber) {
        var card = cardRepository.findByCardNumber(cardNumber);
        var holderName = card.getHolderName();
        return holderName;
    }

    @Transactional
    public String transfer(String cardNumber1, String cardNumber2, BigDecimal amount) {

        var card1 = cardRepository.findByCardNumber(cardNumber1);
        var card2 = cardRepository.findByCardNumber(cardNumber2);

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Transfer amount must be positive");
        }

        if (card1.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance on source card");
        }

        card1.setBalance(card1.getBalance().subtract(amount));
        card2.setBalance(card2.getBalance().add(amount));

        cardRepository.save(card1);
        cardRepository.save(card2);

        return "Transfer successful";
    }


    public BigDecimal getBalance(String cardNumber) {
        var card = cardRepository.findByCardNumber(cardNumber);
        var balance = card.getBalance();
        log.info("Balance: {}", balance);
        return balance;
    }

    public void addBalance(String cardNumber, BigDecimal amount) {
        var card = cardRepository.findByCardNumber(cardNumber);
        card.setBalance(card.getBalance().add(amount));
        cardRepository.save(card);
    }

}
