package com.aquilamazzei.springhunter.consts;

import com.aquilamazzei.springhunter.entities.HeroClass;
import com.aquilamazzei.springhunter.entities.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Classes {

    public List<HeroClass> heroClassesList = new ArrayList<>();

    public Classes(){
        heroClassesList.add(new HeroClass(ClassNames.BARBARIAN,150.0,3.0, 2.0, 1.0));
        heroClassesList.add(new HeroClass(ClassNames.SOLDIER,120.0,4.0, 4.0, 1.0));
        heroClassesList.add(new HeroClass(ClassNames.BASTION,110.0,3.0, 7.0, 1.0));
        heroClassesList.add(new HeroClass(ClassNames.TREASURE_HUNTER,90.0,3.0, 4.0, 3.0));
        heroClassesList.add(new HeroClass(ClassNames.SCRAPPER,100.0,3.0, 3.0, 2.0));
    }
}
