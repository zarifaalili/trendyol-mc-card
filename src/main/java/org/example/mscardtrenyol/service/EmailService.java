package org.example.mscardtrenyol.service;

import lombok.RequiredArgsConstructor;
import org.example.mscardtrenyol.repository.EmailRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailRepository emailRepository;

    public Boolean checkEmailExists(String email) {
        var emailExists = emailRepository.findByEmail(email).orElse(null);
        if (emailExists == null) {
            return false;
        }
        return true;
    }
}
