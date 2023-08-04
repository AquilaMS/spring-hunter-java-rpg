package com.aquilamazzei.springhunter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Peon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer level = 1;
    private Double damage;
    private Double defense;
    private Double life;
    private Double experience = 0.0;

    public void die() {
        System.out.println(getName() + ": " + "DIED");
    }

}