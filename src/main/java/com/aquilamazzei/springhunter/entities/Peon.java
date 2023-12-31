package com.aquilamazzei.springhunter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Entity
public class Peon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String peonName;
    private Integer level = 1;
    private Double damage;
    private Double defense;
    private Double life;
    private Double experience = 0.0;
}