package com.aquilamazzei.springhunter.logics;

import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.Monster;

public class Fight {

    public static Hero attack(Hero attacker){
        Monster target = Monster.chooseMonster(attacker);
        System.out.println(target.getName());
        do {
            Integer rollResultToTarget = Dice.rollD20();
            Double damageToTarget = (((attacker.getDamage()) * attacker.getLevel())/(target.getLevel() * target.getDefense())*(rollResultToTarget)) * 0.55;

            Integer rollResultToAttacker = Dice.rollD20();
            Double damageToAttacker = (((target.getDamage()) * target.getLevel())/(attacker.getLevel() * attacker.getDefense())*(rollResultToAttacker)) * 0.5;

            target.setLife(target.getLife() - damageToTarget);
            attacker.setLife(attacker.getLife() - damageToAttacker);

            if (target.getLife() <= 0){
                target.die();
                Monster.dropWeaponTo(attacker);

                attacker.giveExp((target.getDropExp()));
            }
            if (attacker.getLife() <= 0) {attacker.die();}

        }while (target.getLife() > 0 && attacker.getLife()> 0);

            System.out.println("monster life "+target.getLife());
            System.out.println("hero life " +attacker.getLife());

        return attacker;
    }
}
