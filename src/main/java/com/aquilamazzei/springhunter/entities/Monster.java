package com.aquilamazzei.springhunter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Monster extends Peon implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private Double dropExp;

    public Monster(String name, double life, double defense, int level, double damage, double dropExp) {
        super();
        setName(name);
        setLife(life);
        setDefense(defense);
        setLevel(level);
        setDamage(damage);
        setDropExp(dropExp);
    }
}
