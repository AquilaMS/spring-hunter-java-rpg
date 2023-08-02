package com.aquilamazzei.springhunter.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
public class HeroClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String className;
    private Double life;
    private Double damage;
    private Double defense;
    private Double luck;
    private Double specBonus;

    public HeroClass(String className, Double life, Double damage, Double defense, Double luck, Double specBonus) {
        this.className = className;
        this.life = life;
        this.damage = damage;
        this.defense = defense;
        this.luck = luck;
        this.specBonus = specBonus;
    }
}
