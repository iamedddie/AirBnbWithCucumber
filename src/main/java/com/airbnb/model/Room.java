package com.airbnb.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Room {
    private String name;
    private double rate;
    @Id
    @GeneratedValue
    private Long id;
}
