package org.example.mscardtrenyol.controller;

import lombok.RequiredArgsConstructor;
import org.example.mscardtrenyol.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;


    @GetMapping("/exists/{email}")
    public Boolean checkEmailExists(@PathVariable String email) {
        return emailService.checkEmailExists(email);
    }

}
