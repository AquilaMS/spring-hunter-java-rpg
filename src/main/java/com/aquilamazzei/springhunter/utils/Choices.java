package com.aquilamazzei.springhunter.utils;

import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.Monster;
import com.aquilamazzei.springhunter.logics.Dice;
import com.aquilamazzei.springhunter.logics.Fight;
import com.aquilamazzei.springhunter.utils.enums.ChoicesOptions;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Choices {


    private String title;
    private String description;

    @Autowired
    public ChoicesOptions generatedOption;

    public Choices() {

        List<ChoicesOptions> tempOptionsList = new ArrayList<>(Arrays.asList(ChoicesOptions.values()));
        generatedOption = tempOptionsList.get(Dice.rollCustom(tempOptionsList.size()));

        switch (generatedOption){
            case EARN_LIFE-> {
                this.title = "Healing Light";
                this.description = "Heal your character in ";
            }
            case EARN_DEFENSE-> {
                this.title = "Enhance Armor";
                this.description = "Increase Armor";
            }
            case EARN_LUCK-> {
                this.title = "Get a luck amulet";
                this.description = "Increase Luck";
            }
            case EARN_DAMAGE-> {
                this.title = "Study the Enemy's Weak Points";
                this.description = "Increase Damage";
            }
            case EARN_EXPERIENCE-> {
                this.title = "Train Tactics";
                this.description = "Increase Experience";
            }
            case LOSS_LIFE_EARN_DEFENSE-> {
                this.title = "A Needed Sacrifice";
                this.description = "Lose Life to get Defense";
            }
            case LOSS_LIFE_EARN_DAMAGE-> {
                this.title = "Battle Scars";
                this.description = "Lose Life to get Damage";
            }
            case FIGHT-> {
                this.title = "Search For a Enemy";
                this.description = "Start a fight";
            }
            case DROP_WEAPON-> {
                this.title = "Search the Scrap Pile";
                this.description = "Drop a Weapon";
            }
        }
    }

    public static String chosenOption(Hero hero, ChoicesOptions choice){
        switch (choice){
            case EARN_LIFE -> {return earnLife(hero);}
            case EARN_DEFENSE -> { return earnDefense(hero);}
            case EARN_LUCK -> {return earnLuck(hero);}
            case EARN_DAMAGE -> {return earnDamage(hero);}
            case EARN_EXPERIENCE -> {return earnExperience(hero);}
            case LOSS_LIFE_EARN_DEFENSE -> {return lossLifeEarnDefense(hero);}
            case LOSS_LIFE_EARN_DAMAGE -> {return lossLifeEarnDamage(hero);}
            case FIGHT -> {return fight(hero);}
            case DROP_WEAPON -> {return dropWeapon(hero);}
        }

        return null;
    }

    public static String earnLife(Hero hero){
        Double value = (double) Dice.rollD20() + 4;
        hero.setLife(hero.getLife() + value);
        return hero.getPeonName() +" earned " + value + " Life";
    }

    public static String earnDefense(Hero hero){
        Double value = (double) Dice.rollD4();
        hero.setDefense(hero.getDefense() + value);
        return hero.getPeonName() +" earned " + value + " Defense";
    }

    public static String earnLuck(Hero hero){
        Double value = (double) (Dice.rollD4())/4;
        hero.setLuck(hero.getLuck() + value);
        return hero.getPeonName() +" earned " + value + " Luck";
    }

    public static String earnDamage(Hero hero){
        Double value = (double) Dice.rollD4();
        hero.setDamage(hero.getDamage() + value);
        return hero.getPeonName() +" earned " + value + " Damage";
    }

    public static String earnExperience(Hero hero){
        Double value = (double) ((Dice.rollD20() + Dice.rollD20())*10);
        hero.giveExp(value);
        return hero.getPeonName() +" earned " + value + " Experience";
    }

    public static String lossLifeEarnDefense(Hero hero){
        Double lossValue = Double.valueOf(Dice.roll3X_D4());
        Double earnValue = Double.valueOf(Dice.rollD4());
        if(hero.getLife() - lossValue < 0) hero.setLife(hero.getLife() - lossValue);

        hero.setDefense(hero.getDefense() + earnValue);
        return hero.getPeonName() +" earned " + earnValue + " Defense and losses " + lossValue;
    }

    public static String lossLifeEarnDamage(Hero hero){
        Double lossValue = Double.valueOf(Dice.roll3X_D4());
        Double earnValue = Double.valueOf(Dice.rollD4());
        if(hero.getLife() - lossValue < 0) hero.setLife(hero.getLife() - lossValue);

        hero.setDamage(hero.getDamage() + earnValue);
        return hero.getPeonName() +" earned " + earnValue + " Damage and losses " + lossValue;
    }

    public static String fight(Hero hero){
        Fight fight = new Fight();
        fight.attack(hero);
        return hero.getPeonName() + " starts a Fight. Actual hero Life: " + hero.getLife();
    }

    public static String dropWeapon(Hero hero){
        Double oldHeroDamage = hero.getDamage();
        Monster.dropWeaponTo(hero);
        double earnedDamage = hero.getDamage() - oldHeroDamage;
        if(oldHeroDamage >= hero.getDamage()){return hero.getPeonName() + " got a weak Weapon";}
        else{return hero.getPeonName() + " got a good Weapon and got " + earnedDamage + " Damage";}
    }
}
