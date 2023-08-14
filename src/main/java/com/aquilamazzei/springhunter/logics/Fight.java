package com.aquilamazzei.springhunter.logics;

import com.aquilamazzei.springhunter.dto.Fight.FightResult;
import com.aquilamazzei.springhunter.dto.Hero.ResponseCreatedHero;
import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.Monster;
import com.aquilamazzei.springhunter.entities.Weapon;
import com.aquilamazzei.springhunter.services.HeroService;
import com.aquilamazzei.springhunter.utils.enums.ClassNames;
import org.springframework.beans.factory.annotation.Autowired;

public class Fight {

    public FightResult attack(Hero attacker){
        Monster target = Monster.chooseMonster(attacker);
        Weapon droppedWeapon = new Weapon();
        System.out.println(target.getPeonName());
        int playerDiceSum = 0;
        int monsterDiceSum = 0;
        do {
            Integer rollResultToTarget = Dice.rollD20();
            playerDiceSum += rollResultToTarget;
            Double damageToTarget = (((attacker.getDamage()) * attacker.getLevel())/(target.getLevel() * target.getDefense())*(rollResultToTarget)) * 0.6;

            Integer rollResultToAttacker = Dice.rollD20();
            monsterDiceSum += rollResultToAttacker;
            Double damageToAttacker = (((target.getDamage()) * target.getLevel())/(attacker.getLevel() * attacker.getDefense())*(rollResultToAttacker)) * 0.5;

            target.setLife(target.getLife() - damageToTarget);
            attacker.setLife(attacker.getLife() - damageToAttacker);

            if (target.getLife() <= 0){
                if(attacker.getHeroProfession().getClassName().equals(ClassNames.TREASURE_HUNTER)){
                    attacker.setGold(attacker.getGold() + 15);
                }
                attacker.setGold(attacker.getGold() + 10);
                droppedWeapon = Monster.dropWeaponTo(attacker);
                attacker.giveExp((target.getDropExp()));
            }


        }while (target.getLife() > 0 && attacker.getLife()> 0);

        ResponseCreatedHero responseEndHero = new ResponseCreatedHero(
                attacker.getHeroProfession().getId(),
                attacker.getPeonName(),
                attacker.getLevel(),
                attacker.getHeroProfession().getClassName(),
                attacker.getDamage(),
                attacker.getDefense(),
                attacker.getLife(),
                attacker.getExperience(),
                attacker.getIsAlive(),
                attacker.getGold(),
                attacker.getWeapon()
        );
        FightResult result = new FightResult(responseEndHero, target, droppedWeapon, playerDiceSum, monsterDiceSum);
        return result;
    }
}
