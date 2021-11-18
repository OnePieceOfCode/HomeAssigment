package com.example.advertisinganalizator.io.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clicks")
public class Click {

    @Id
    @GeneratedValue
    private Long id;

    private String session_id;

    private String epochTimestamp;

    private Integer timePass;
}
