package com.aquilamazzei.springhunter.utils;

import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.Monster;
import com.aquilamazzei.springhunter.entities.Weapon;
import com.aquilamazzei.springhunter.logics.Dice;
import com.aquilamazzei.springhunter.logics.Fight;
import com.aquilamazzei.springhunter.utils.enums.ChoicesOptions;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Choices {
    @Data
    class Messager{
        private String message1;
        private String message2;
    }

    private String title;
    private String description;

    @Autowired
    public ChoicesOptions generatedOption;

    public Choices() {

        List<ChoicesOptions> tempOptionsList = new ArrayList<>();
        tempOptionsList.addAll(Arrays.asList(ChoicesOptions.values()));
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
                this.description = "Drop a weapon";
            }
        }
    }

    
    public void chosenOption(Hero hero){
        switch (getGeneratedOption()){
            case EARN_LIFE -> {earnLife(hero);}
            case EARN_DEFENSE -> {earnDefense(hero);}
            case EARN_LUCK -> {earnLuck(hero);}
            case EARN_DAMAGE -> {earnDamage(hero);}
            case EARN_EXPERIENCE -> {earnExperience(hero);}
            case LOSS_LIFE_EARN_DEFENSE -> {lossLifeEarnDefense(hero);}
            case LOSS_LIFE_EARN_DAMAGE -> {lossLifeEarnDamage(hero);}
            case FIGHT -> {fight(hero);}
            case DROP_WEAPON -> {dropWeapon(hero);}
        }
    }

    public static void earnLife(Hero hero){
        hero.setLife(hero.getLife() + (Dice.rollD20() + 4));
    }

    public static void earnDefense(Hero hero){
        hero.setDefense(hero.getDefense() + (Dice.rollD4()));
    }

    public static void earnLuck(Hero hero){
        hero.setLuck(hero.getLuck() + (Dice.rollD4())/2);
    }

    public static void earnDamage(Hero hero){
        hero.setDamage(hero.getDamage() + (Dice.rollD4()));
    }

    public static void earnExperience(Hero hero){
       hero.giveExp((double) (Dice.rollD20() + Dice.rollD20())*10);
    }

    public static void lossLifeEarnDefense(Hero hero){
        hero.setLife(hero.getLife() - Dice.roll3X_D4());
        hero.setDefense(hero.getDefense() + Dice.rollD4());
    }

    public static void lossLifeEarnDamage(Hero hero){
        hero.setLife(hero.getLife() - (Dice.rollD4() + Dice.rollD4()));
        hero.setDamage(hero.getDamage() + Dice.rollD4());
    }

    public static void fight(Hero hero){
        Fight.attack(hero);
    }

    public static void dropWeapon(Hero hero){
        Monster.dropWeapon(hero);
    }
}
