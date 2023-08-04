package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.consts.ClassNames;
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

    private ClassNames className;
    private Double life;
    private Double damage;
    private Double defense;
    private Double luck;

    public HeroClass(ClassNames className, Double life, Double damage, Double defense, Double luck) {
        this.className = className;
        this.life = life;
        this.damage = damage;
        this.defense = defense;
        this.luck = luck;
    }
}
