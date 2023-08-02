package com.aquilamazzei.springhunter.consts;

import com.aquilamazzei.springhunter.entities.HeroClass;
import com.aquilamazzei.springhunter.entities.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Classes {

    public List<HeroClass> heroClassesList = new ArrayList<>();

    public Classes(){
        heroClassesList.add(new HeroClass("Barbarian",150.0,6.0, 2.0, 1.0, 0.0));
        heroClassesList.add(new HeroClass("Soldier",120.0,3.0, 4.0, 2.0, 0.0));
        heroClassesList.add(new HeroClass("Bastion",110.0,2.0, 7.0, 2.0, 0.0));
        heroClassesList.add(new HeroClass("Treasure Hunter",90.0,3.0, 3.0, 4.0, 0.0));
        heroClassesList.add(new HeroClass("Scrapper",100.0,2.0, 2.0, 2.0, 3.0));
    }
}
