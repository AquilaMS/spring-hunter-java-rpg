package com.aquilamazzei.springhunter.utils;

import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.logics.Dice;
import lombok.Data;

@Data
public class Choices {

    private String title;
    private String description;

    public void generateOption(){

    }

    public static Double earnLife(Hero hero){
        return Double.valueOf(Dice.rollD20());
    }

    public static Double earnDefense(Hero hero){
        return Double.valueOf(Dice.rollD20());
    }

    public static Double earnLuck(Hero hero){
        return Double.valueOf(Dice.rollD20());
    }

    public static Double earnDamage(Hero hero){
        return Double.valueOf(Dice.rollD20());
    }

    public static Double earnExperience(Hero hero){
        return Double.valueOf(Dice.rollD20());
    }

    public static Double lossLifeEarnDefense(Hero hero){
        return Double.valueOf(Dice.rollD20());
    }

    public static Double lossLifeEarnDamage(Hero hero){
        return Double.valueOf(Dice.rollD20());
    }

    public static Double fight(Hero hero){
        return Double.valueOf(Dice.rollD20());
    }

    public static Double dropWeapon(Hero hero){
        return Double.valueOf(Dice.rollD20());
    }
}
