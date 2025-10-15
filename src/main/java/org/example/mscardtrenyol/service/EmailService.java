package org.example.mscardtrenyol.service;

import lombok.RequiredArgsConstructor;
import org.example.mscardtrenyol.model.enums.Status;
import org.example.mscardtrenyol.repository.EmailRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailRepository emailRepository;

    public Boolean checkEmailExists(String email) {
        var emailExists = emailRepository.findByEmailAndStatus(email, Status.ACTIVE).orElse(null);
        return emailExists != null;
    }
}
