package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.consts.Weapons;
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

    private Double luck;

    public Hero(Player player, HeroClass heroClass,  String name) {
        this.player = player;
        this.heroClass = heroClass;
        this.luck = heroClass.getLuck();

        setLife(heroClass.getLife());
        setDamage(heroClass.getDamage());
        setDefense(heroClass.getDefense());
        setName(name);
    }

    public void equipWeapon(Weapon weapon){
        //TODO: terminar o equip de item com Spec
        this.setDamage(weapon.getDamage());
        System.out.println(weapon);
    }
}
