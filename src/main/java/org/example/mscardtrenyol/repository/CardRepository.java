package org.example.mscardtrenyol.repository;

import org.example.mscardtrenyol.entity.Card;
import org.example.mscardtrenyol.service.CardService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    boolean existsByCardNumber(String cardNumber);

    boolean existsByCardNumberAndHolderName(String cardNumber, String holderName);

    boolean existsByCardNumberAndHolderNameAndIsActive(String cardNumber, String holderName, Boolean isActive);

    boolean existsByCardNumberAndIsActive(String cardNumber, Boolean isActive);

    Card findByCardNumber(String cardNumber);
}
