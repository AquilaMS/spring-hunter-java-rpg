package com.aquilamazzei.springhunter.consts;

import com.aquilamazzei.springhunter.entities.Monster;

import java.util.ArrayList;
import java.util.List;

public class Monsters {

    List<Monster> monstersList = new ArrayList<>();

    public Monsters(){
        monstersList.add(new Monster("Slime",10.0,0.0, 1, 1.0,20));
        monstersList.add(new Monster("Goblin",15.0,1.0, 1, 1.5,30));
        monstersList.add(new Monster("Skeleton",17.0,1.5, 1, 1,45));
        monstersList.add(new Monster("Orc",25.0,2.0, 2, 1,55));
        monstersList.add(new Monster("Troll",29.0,2.7, 2, 1,65));
        monstersList.add(new Monster("Vampire",35.0,3.0, 3, 1,80));
        monstersList.add(new Monster("Harpy",42.0,3.3, 4, 1,90));
        monstersList.add(new Monster("Minotaur",55.0,4.0, 4, 1,95));
        monstersList.add(new Monster("Giant",65.0,4.5, 4, 1,105));
        monstersList.add(new Monster("Hydra",79.0,5.0, 5, 1,120));
        monstersList.add(new Monster("Elder Mummy",95.0,6.0, 7, 1,130));
        monstersList.add(new Monster("Wyrvern",110.0,7.0, 8, 1,135));
        monstersList.add(new Monster("Forest Spirit",170.0,9.0, 10, 1,160));
        monstersList.add(new Monster("Scaless Dragon",250.0,2.0, 15, 1,200));
        monstersList.add(new Monster("Baby Crystal Dragon",110.0,20.0, 20, 1,250));
        monstersList.add(new Monster("The Spider Queen",250.0,6.0, 25, 1,350));
        monstersList.add(new Monster("The Deimos",400.0,9.0, 30, 10,450));
    }
}
