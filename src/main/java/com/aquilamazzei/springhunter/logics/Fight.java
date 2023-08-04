package com.aquilamazzei.springhunter.logics;

import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.Monster;
import com.aquilamazzei.springhunter.entities.Peon;

public class Fight {



    public void attack(Hero attacker, Peon target){

        do {
            Integer rollResultToTarget = Dice.rollD20();
            Double damageToTarget = (((attacker.getDamage()) * attacker.getLevel())/(target.getLevel() * target.getDefense())*(rollResultToTarget)) * 0.55;

            Integer rollResultToAttacker = Dice.rollD20();
            Double damageToAttacker = (((target.getDamage()) * target.getLevel())/(attacker.getLevel() * attacker.getDefense())*(rollResultToAttacker)) * 0.5;

            target.setLife(target.getLife() - damageToTarget);
            attacker.setLife(attacker.getLife() - damageToAttacker);

            if (target.getLife() <= 0){
                target.die();
                Monster monster = (Monster) target;
                attacker.giveExp(monster.getDropExp());
            }
            if (attacker.getLife() <= 0) {attacker.die();}

        }while (target.getLife() > 0 && attacker.getLife()> 0);
    }
}
