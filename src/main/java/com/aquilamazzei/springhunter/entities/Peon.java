package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.consts.QualityTypes;
import com.aquilamazzei.springhunter.consts.WeaponType;
import com.aquilamazzei.springhunter.consts.Weapons;
import com.aquilamazzei.springhunter.logics.Dice;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public void die() {
        System.out.println(getName() + ": " + "DIED");
    }

    public void passLevel() {
        setLevel(getLevel() + 1);
    }

    public void giveExp(Double exp) {
        Double needToNextLevel = 100 + (level * 50.0);
        setExperience(getExperience() + exp);
        if (getExperience() >= needToNextLevel) {
            passLevel();
            setExperience(getExperience() - needToNextLevel);
        }
    }

    public void dropWeapon(Hero hero) {

        int diceType = Dice.rollCustom(4);
        WeaponType type = WeaponType.none;
        switch (diceType) {
            case 0 -> type = WeaponType.SWORD;
            case 1 -> type = WeaponType.SHIELD;
            case 2 -> type = WeaponType.AXE;
            case 3 -> type = WeaponType.PISTOL;
        }
        int diceItem = Dice.rollCustom(100);
        int indexItem = 0;
/*
        if (diceItem >= 98) {indexItem = 7;}
        if (diceItem >= 95 && diceItem < 98) {indexItem = 6;}
        if (diceItem >= 90 && diceItem < 95) {indexItem = 5;}
        if (diceItem >= 83 && diceItem < 90) {indexItem = 4;}
        if (diceItem >= 68 && diceItem < 83) {indexItem = 3;}
        if (diceItem >= 51 && diceItem < 68) {indexItem = 2;}
        if (diceItem >= 43 && diceItem < 51) {indexItem = 1;}
        if (diceItem >= 18 && diceItem < 43) {indexItem = 0;}

*/
        Weapons weapons = new Weapons();
         int diceChooseItem = Dice.rollD20() + Dice.rollD20();
        if (diceChooseItem == 40) {
            indexItem = weapons.weaponsList.get(diceType).size() - 1;
            hero.equipWeapon(weapons.weaponsList.get(diceType).get(indexItem));
        }else {
            hero.equipWeapon(Weapon.selectItemFromList(weapons.weaponsList.get(diceType), Dice.rollDouble()));
        }

        if(Dice.rollD20() >= hero.getLuck());


        //Weapon gotWeapon = weapons.weaponsList.get(diceType).get(indexItem);

        //System.out.println(gotWeapon);
        //System.out.println(indexItem);
       // System.out.println(Weapon.createQuality());


    }
}