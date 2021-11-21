package com.example.advertisinganalizator.io.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "users_requests")
public class UsersRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String epochTimestamp;

    private String sessionId;

    private String partner;

    private String userId;

    private Double bid;

    private Boolean isWin;
}



