package com.aquilamazzei.springhunter.logics;

import com.aquilamazzei.springhunter.entities.Monster;
import com.aquilamazzei.springhunter.entities.Peon;

public class Fight {



    public void attack(Peon attacker, Peon target){

        do {
            Dice dice1 = new Dice();
            Integer rollResultToTarget = dice1.roll();
            Double damageToTarget = (((attacker.getDamage()) * attacker.getLevel())/(target.getLevel() * target.getDefense())*(rollResultToTarget)) * 0.55;

            Dice dice2 = new Dice();
            Integer rollResultToAttacker = dice2.roll();
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
