package com.example.OfficeApplication.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String role; // ROLE_MANAGER, ROLE_DEVELOPER
}