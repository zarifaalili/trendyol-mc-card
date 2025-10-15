package org.example.mscardtrenyol.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mscardtrenyol.model.enums.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "emails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private Status status;


}
