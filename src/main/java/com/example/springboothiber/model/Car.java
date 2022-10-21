package com.example.springboothiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars", schema = "service")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_id")
    private Owner owner;
}
