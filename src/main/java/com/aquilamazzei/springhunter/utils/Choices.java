package com.aquilamazzei.springhunter.utils;

import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.Monster;
import com.aquilamazzei.springhunter.logics.Dice;
import com.aquilamazzei.springhunter.logics.Fight;
import com.aquilamazzei.springhunter.services.HeroService;
import com.aquilamazzei.springhunter.utils.enums.ChoicesOptions;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Service
public class Choices {


    private String title;
    private String description;

    @Autowired
    private HeroService heroServicee;

    public ChoicesOptions generatedOption;

    public Choices() {

        List<ChoicesOptions> tempOptionsList = new ArrayList<>(Arrays.asList(ChoicesOptions.values()));
        generatedOption = tempOptionsList.get(Dice.rollCustom(tempOptionsList.size()));

        switch (generatedOption) {
            case EARN_LIFE -> {
                this.title = "Healing Light";
                this.description = "Heal your character in ";
            }
            case EARN_DEFENSE -> {
                this.title = "Enhance Armor";
                this.description = "Increase Armor";
            }
            case EARN_LUCK -> {
                this.title = "Get a luck amulet";
                this.description = "Increase Luck";
            }
            case EARN_DAMAGE -> {
                this.title = "Study the Enemy's Weak Points";
                this.description = "Increase Damage";
            }
            case EARN_EXPERIENCE -> {
                this.title = "Train Tactics";
                this.description = "Increase Experience";
            }
            case LOSS_LIFE_EARN_DEFENSE -> {
                this.title = "A Needed Sacrifice";
                this.description = "Lose Life to get Defense";
            }
            case LOSS_LIFE_EARN_DAMAGE -> {
                this.title = "Battle Scars";
                this.description = "Lose Life to get Damage";
            }
            case FIGHT -> {
                this.title = "Search For a Enemy";
                this.description = "Start a fight";
            }
            case DROP_WEAPON -> {
                this.title = "Search the Scrap Pile";
                this.description = "Drop a Weapon";
            }
        }
    }

    public String chosenOption(Hero hero, ChoicesOptions choice,HeroService heroService) {
        System.out.println(hero);
        switch (choice) {
            case EARN_LIFE -> {
                return earnLife(hero,heroService);
            }
            case EARN_DEFENSE -> {
                return earnDefense(hero,heroService);
            }
            case EARN_LUCK -> {
                return earnLuck(hero,heroService);
            }
            case EARN_DAMAGE -> {
                return earnDamage(hero,heroService);
            }
            case EARN_EXPERIENCE -> {
                return earnExperience(hero,heroService);
            }
            case LOSS_LIFE_EARN_DEFENSE -> {
                return lossLifeEarnDefense(hero,heroService);
            }
            case LOSS_LIFE_EARN_DAMAGE -> {
                return lossLifeEarnDamage(hero,heroService);
            }
            case FIGHT -> {
                return fight(hero,heroService);
            }
            case DROP_WEAPON -> {
                return dropWeapon(hero,heroService);
            }
        }

        return null;
    }

    public String earnLife(Hero hero,HeroService heroService) {
        Double value = (double) Dice.rollD20() + 4;
        hero.setLife(hero.getLife() + value);
        heroService.updateHero(hero);
        return hero.getPeonName() + " earned " + value + " Life";
    }

    public String earnDefense(Hero hero,HeroService heroService) {
        Double value = (double) Dice.rollD4();
        hero.setDefense(hero.getDefense() + value);
        heroService.updateHero(hero);
        return hero.getPeonName() + " earned " + value + " Defense";
    }

    public String earnLuck(Hero hero,HeroService heroService) {
        Double value = (double) (Dice.rollD4()) / 4;
        hero.setLuck(hero.getLuck() + value);
        heroService.updateHero(hero);
        return hero.getPeonName() + " earned " + value + " Luck";
    }

    public String earnDamage(Hero hero,HeroService heroService) {
        Double value = (double) Dice.rollD4();
        hero.setDamage(hero.getDamage() + value);
        heroService.updateHero(hero);
        return hero.getPeonName() + " earned " + value + " Damage";
    }

    public String earnExperience(Hero hero,HeroService heroService) {
        Double value = (double) ((Dice.rollD20() + Dice.rollD20()) * 10);
        hero.giveExp(value);
        heroService.updateHero(hero);
        return hero.getPeonName() + " earned " + value + " Experience";
    }

    public String lossLifeEarnDefense(Hero hero,HeroService heroService) {
        Double lossValue = Double.valueOf(Dice.roll3X_D4());
        Double earnValue = Double.valueOf(Dice.rollD4());
        if (hero.getLife() - lossValue < 0) hero.setLife(hero.getLife() - lossValue);
        heroService.updateHero(hero);
        hero.setDefense(hero.getDefense() + earnValue);
        return hero.getPeonName() + " earned " + earnValue + " Defense and losses " + lossValue;
    }

    public String lossLifeEarnDamage(Hero hero,HeroService heroService) {
        Double lossValue = Double.valueOf(Dice.roll3X_D4());
        Double earnValue = Double.valueOf(Dice.rollD4());
        if (hero.getLife() - lossValue < 0) hero.setLife(hero.getLife() - lossValue);

        hero.setDamage(hero.getDamage() + earnValue);

        heroService.updateHero(hero);
        return hero.getPeonName() + " earned " + earnValue + " Damage and losses " + lossValue;
    }

    public String fight(Hero hero,HeroService heroService) {
        Fight fight = new Fight();
        fight.attack(hero);
        heroService.updateHero(hero);
        return hero.getPeonName() + " starts a Fight. Actual hero Life: " + hero.getLife();
    }

    public String dropWeapon(Hero hero,HeroService heroService) {
        Double oldHeroDamage = hero.getDamage();
        Monster.dropWeaponTo(hero);
        double earnedDamage = hero.getDamage() - oldHeroDamage;
        if (oldHeroDamage >= hero.getDamage()) {
            return hero.getPeonName() + " got a weak Weapon";
        } else {
            heroService.updateHero(hero);
            return hero.getPeonName() + " got a good Weapon and got " + earnedDamage + " Damage";
        }
    }
}
