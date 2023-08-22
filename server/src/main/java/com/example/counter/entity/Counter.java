package com.example.counter.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "counter")
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long counterValue;
}
