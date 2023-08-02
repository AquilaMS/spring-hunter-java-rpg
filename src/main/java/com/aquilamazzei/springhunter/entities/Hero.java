package com.aquilamazzei.springhunter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Hero extends Peon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Player player;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "heroclass_id")
    private HeroClass heroClass;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    public Hero(Player player, HeroClass heroClass, Weapon weapon, String name) {
        this.player = player;
        this.heroClass = heroClass;
        this.weapon = weapon;

        setLife(heroClass.getLife());
        setDamage(heroClass.getDamage() + weapon.getDamage());
        setDefense(heroClass.getDefense());
        setName(name);
    }
}
