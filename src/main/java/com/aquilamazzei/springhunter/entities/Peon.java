package com.aquilamazzei.springhunter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

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

    public void die(){
        System.out.println(getName() + ": " + "DIED");
    }

    public void passLevel(){
        setLevel(getLevel() + 1);
    }

    public void giveExp(Double exp){
        Double needToNextLevel = 100 + (level * 50.0);
        System.out.println(("next level: " + needToNextLevel));
        setExperience(getExperience() + exp);
        if(getExperience() >= needToNextLevel){
            passLevel();
            setExperience(getExperience()-needToNextLevel);
        }
    }
}
