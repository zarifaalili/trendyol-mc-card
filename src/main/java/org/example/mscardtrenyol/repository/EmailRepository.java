package org.example.mscardtrenyol.repository;

import org.example.mscardtrenyol.entity.Email;
import org.example.mscardtrenyol.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailRepository extends JpaRepository<Email, Long> {
    Optional<Email> findByEmail(String email);

    Optional<Object> findByEmailAndStatus(String email, Status status);
}
