package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.consts.ClassNames;
import com.aquilamazzei.springhunter.consts.WeaponType;
import com.aquilamazzei.springhunter.consts.Weapons;
import com.aquilamazzei.springhunter.logics.Dice;
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

    public void equipWeapon(Weapon weapon, Hero hero){
        ClassNames ownerClass = (ClassNames) hero.getHeroClass().getClassName();

        Double luckBonus = Weapon.insertBonus(weapon, hero);
        Double newWeaponDamage = (weapon.getDamage()) + (weapon.getDamage() * luckBonus);

        Double specBonus = Weapon.insertBonus(weapon, hero);

        if(ownerClass == ClassNames.BARBARIAN && weapon.getType() == WeaponType.AXE) {newWeaponDamage += specBonus;}
        if(ownerClass == ClassNames.SOLDIER && weapon.getType() == WeaponType.SWORD) {newWeaponDamage += specBonus;}
        if(ownerClass == ClassNames.BASTION && weapon.getType() == WeaponType.SHIELD) {newWeaponDamage += specBonus;}
        if(ownerClass == ClassNames.TREASURE_HUNTER && weapon.getType() == WeaponType.PISTOL) {newWeaponDamage += specBonus;}
        if(ownerClass == ClassNames.SCRAPPER) {newWeaponDamage += specBonus * 0.8;}

        if(newWeaponDamage > hero.getDamage()) {hero.setDamage(newWeaponDamage);}
    }
}
