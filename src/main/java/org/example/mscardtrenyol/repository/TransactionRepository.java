package org.example.mscardtrenyol.repository;

import org.example.mscardtrenyol.entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<PaymentTransaction, Long> {
    List<PaymentTransaction> findByReceiver(String receiver);
}
