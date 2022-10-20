package com.example.springboothiber.model;

import javax.persistence.*;

//@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;
}
