package com.aquilamazzei.springhunter.utils;

import com.aquilamazzei.springhunter.entities.Monster;

import java.util.ArrayList;
import java.util.List;

public class Monsters {

    public List<Monster> monstersList = new ArrayList<>();

    public Monsters(){
        //1 - 10
        monstersList.add(new Monster("Slime",10.0,0.0, 1, 1.0,50));
        monstersList.add(new Monster("Goblin",20.0,1.0, 2, 1,60));
        monstersList.add(new Monster("Skeleton",30.0,1.0, 3, 1,70));
        monstersList.add(new Monster("Orc",35.0,3.0, 4, 1,80));
        monstersList.add(new Monster("Troll",40.0,4.0, 5, 2,85));
        monstersList.add(new Monster("Slime",50.0,5.0, 6, 2,90));
        monstersList.add(new Monster("Goblin",55.0,6.0, 7, 2,95));
        monstersList.add(new Monster("Skeleton",60.0,6.0, 8, 3,100));
        monstersList.add(new Monster("Mountain Orc",70.0,7.0, 9, 3,110));

        //11 - 20
        monstersList.add(new Monster("Toxic Mushroom",100,7.0, 10, 4,115));
        monstersList.add(new Monster("Fading Ghost",125.0,7.0, 11, 4,125));
        monstersList.add(new Monster("Harpy",150.0,8.0, 12, 3,90));
        monstersList.add(new Monster("Small Earth Elemental",175.0,8.0, 13, 4,130));
        monstersList.add(new Monster("Horned Insect",200.0,10.0, 15, 5,135));
        monstersList.add(new Monster("Darkling Hound",250.0,12.0, 16, 6,145));
        monstersList.add(new Monster("Frail Poltergeist",275.0,12.0, 18, 7,155));
        monstersList.add(new Monster("Whispering Phantom",300.0,14.0, 19, 8,170));
        monstersList.add(new Monster("Acidic Droplet",350.0,14.0, 21, 9,190));
        monstersList.add(new Monster("Feeble Goblin",375.0,16.0, 24, 10,200));

        //21 - 30
        monstersList.add(new Monster("Troll",400.0,16.0, 25, 10,210));
        monstersList.add(new Monster("Vampire",425.0,20.0, 28, 11,220));
        monstersList.add(new Monster("Harpy",450.0,20.0, 29, 11,230));
        monstersList.add(new Monster("Minotaur",475.0,20.0, 32, 12,240));
        monstersList.add(new Monster("Giant",500.0,25.0, 33, 12,170));
        monstersList.add(new Monster("Ethereal Assassin",550.,27.0, 36, 13,250));
        monstersList.add(new Monster("Mutant Mushroom",600.0,30.0, 38, 14,260));
        monstersList.add(new Monster("Echoing Specter",700.0,30.0, 40, 15,270));
        monstersList.add(new Monster("Armored Skeleton",800.0,33.0, 46, 16,280));
        monstersList.add(new Monster("Hydra",900.0,36.0, 45, 18,290));

        //31 - 40
        monstersList.add(new Monster("Infernal Hound",1000.0,36.0, 47, 20,300));
        monstersList.add(new Monster("Ethereal Reaper",1250.0,36.0, 49, 22,310));
        monstersList.add(new Monster("Scaless Dragon",1500.0,36.0, 51, 25,320));
        monstersList.add(new Monster("Warlord Goblin",1750.0,36.0, 53, 27,340));
        monstersList.add(new Monster("Mighty Rock Elemental",2000.0,38.0, 55, 30,350));
        monstersList.add(new Monster("Relentless Warrior Spirit",2250.0,40.0, 58, 35,370));
        monstersList.add(new Monster("Lament of The Bravest Sentry",2500.0,50.0, 60, 38,400));
        monstersList.add(new Monster("Monstrous Larva",3000.0,55.0, 15, 41,450));
        monstersList.add(new Monster("Specter of Ruin",3250.0,60.0, 20, 43,500));
        monstersList.add(new Monster("Ghost of The Fallen Empire",3500.0,6.0, 67, 45,550));

        //41 - 50
        monstersList.add(new Monster("Spider Lieutenant",3750.0,60.0, 68, 45,650));
        monstersList.add(new Monster("Spider Marshal",4000,60.0, 70, 48,710));
        monstersList.add(new Monster("Spider Queen",4250.0,60.0, 72, 52,750));
        monstersList.add(new Monster("Corrupted Old Guardian Wyrvern",4500.0,65.0, 74, 55,830));
        monstersList.add(new Monster("Corrupted Spirit of The Ancient Forest",4750.0,65.0, 74, 57,850));
        monstersList.add(new Monster("Corrupted Mother of The Scaless Dragon",5000.0,65.0, 76, 60, 900));
        monstersList.add(new Monster("Corrupted Baby Crystal Dragon",5500.0,65.0, 78, 1,940));
        monstersList.add(new Monster("Corrupted Champion Of The Continent",6000.0,65.0, 80, 62,960));
        monstersList.add(new Monster("Mayllyx's Mouth",6500.0,75.0, 82, 65,970));
        monstersList.add(new Monster("Mayllyx's Eye",7000.0,75.0, 84, 70,980));
        monstersList.add(new Monster("Mayllyx's Hand",7500.0,75.0, 86, 75,990));


        monstersList.add(new Monster("Corrupted Scion Of The Crystal Dragon",8000.0,80.0, 88, 80,1188));


        monstersList.add(new Monster("The Deimos",9999.0,99.0, 99, 99,9999999));
    }
}
