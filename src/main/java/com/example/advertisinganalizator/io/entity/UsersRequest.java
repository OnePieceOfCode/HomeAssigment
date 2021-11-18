package com.example.advertisinganalizator.io.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "usersRequests")
public class UsersRequest {

    @Id
    @GeneratedValue
    private Long id;

    private String epochTimestamp;

    private String session_id;

    private String partner;

    private String user_id;

    private Float bid;

    private Boolean isWin;
}



