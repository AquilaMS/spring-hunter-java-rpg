package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.consts.WeaponType;
import com.aquilamazzei.springhunter.consts.Arsenal;
import com.aquilamazzei.springhunter.logics.Dice;
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

    public static void dropWeapon(Hero hero) {
        int diceType = Dice.rollCustom(4);
        int indexItem = 0;

        Arsenal arsenal = new Arsenal();

        int diceChooseItem = Dice.rollD20() + Dice.rollD20();
        if (diceChooseItem == 40) {
            indexItem = arsenal.weaponsList.get(diceType).size() - 1;
             hero.equipWeapon(arsenal.weaponsList.get(diceType).get(indexItem));
        }else {
            hero.equipWeapon(Weapon.selectItemFromList(arsenal.weaponsList.get(diceType), Dice.rollDouble()));
        }
    }


}
