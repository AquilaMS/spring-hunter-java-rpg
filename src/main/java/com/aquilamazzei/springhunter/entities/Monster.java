package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.utils.Monsters;
import com.aquilamazzei.springhunter.utils.Arsenal;
import com.aquilamazzei.springhunter.logics.Dice;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Monster extends Peon implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double dropExp;

    public Monster(String name, double life, double defense, int level, double damage, double dropExp) {
        super();
        setPeonName(name);
        setLife(life);
        setDefense(defense);
        setLevel(level);
        setDamage(damage);
        setDropExp(dropExp);
    }

    public static Weapon dropWeaponTo(Hero hero) {
        int diceType = Dice.rollCustom(4);
        int indexItem = 0;

        Arsenal arsenal = new Arsenal();

        int diceChooseItem = Dice.rollD20() + Dice.rollD20();
        if (diceChooseItem == 40) {
            indexItem = arsenal.weaponsList.get(diceType).size() - 1;
            Weapon droppedWeapon = arsenal.weaponsList.get(diceType).get(indexItem);
            hero.equipWeapon(droppedWeapon);
            return droppedWeapon;
        }else {
            Weapon droppedWeapon = Weapon.selectItemFromList(arsenal.weaponsList.get(diceType), Dice.rollDouble());
            hero.equipWeapon(droppedWeapon);
            return droppedWeapon;
        }
    }

    private static Monster updateMonsterStatsByLevel(Monster monster, Integer level){
        monster.setDamage(monster.getDamage() + (monster.getDamage() * 0.5));
        monster.setLife(monster.getLife() + (monster.getLife() * 0.15));
        monster.setDefense(monster.getDefense() + (monster.getDefense() * 0.15));
        monster.setDropExp(monster.getDropExp() + (monster.getDropExp() * 0.20));

        return monster;
    }

    public static Monster chooseMonster(Hero hero){
        Random random = new Random();
        List<Monster> tempMonsterList  = new ArrayList<>();
        Monsters monsters = new Monsters();

        for(Monster creature : monsters.monstersList){

            if(hero.getLevel() < creature.getLevel() + 3 && hero.getLevel() > creature.getLevel() - 3){
                tempMonsterList.add(creature);
            }
        }
        Monster gotMonster;

        if (tempMonsterList.size() != 0){
            gotMonster = tempMonsterList.get(random.nextInt(tempMonsterList.size()));
        }else{
            gotMonster = monsters.monstersList.get(monsters.monstersList.size() - 1);
        }

        return updateMonsterStatsByLevel(gotMonster, hero.getLevel());
    }
}
