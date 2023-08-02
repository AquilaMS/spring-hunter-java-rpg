package com.aquilamazzei.springhunter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "type_id")
    @NonNull private Type type;

    @NonNull private String name;
    @NonNull private Double damage;
    @NonNull private Double spec_bonus;
    @NonNull private Integer level;
}
