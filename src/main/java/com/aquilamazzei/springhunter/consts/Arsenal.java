package com.aquilamazzei.springhunter.consts;

import java.util.ArrayList;
import java.util.List;

import com.aquilamazzei.springhunter.entities.Type;
import com.aquilamazzei.springhunter.entities.Weapon;

public class Arsenal {

    public List<Weapon> swordList = new ArrayList<>();
    public List<Weapon> shieldList = new ArrayList<>();
    public List<Weapon> axeList = new ArrayList<>();
    public List<Weapon> pistolList = new ArrayList<>();

    public List<List<Weapon>> weaponsList = new ArrayList<>();

    public Arsenal(){
        swordList.add(new Weapon(WeaponType.SWORD,"Wood Sword",1.0,0.0,0.30));
        swordList.add(new Weapon(WeaponType.SWORD,"Improvised Sword",1.0,0.0,0.17));
        swordList.add(new Weapon(WeaponType.SWORD,"Dull Blade",1.0,2.0,0.15));
        swordList.add(new Weapon(WeaponType.SWORD,"Iron Sword",2.0,2.0,0.13));
        swordList.add(new Weapon(WeaponType.SWORD,"Steel Sword",4.0,2.0,0.10));
        swordList.add(new Weapon(WeaponType.SWORD,"Elite Sword",3.0,4.0,0.08));
        swordList.add(new Weapon(WeaponType.SWORD,"Grandmaster's Sword",3.0,6.0,0.05));
        swordList.add(new Weapon(WeaponType.SWORD,"The Sohothin",7.0,7.0,0.02));

        shieldList.add(new Weapon(WeaponType.SHIELD,"Thorin's Shield",1.0,0.0,0.3));
        shieldList.add(new Weapon(WeaponType.SHIELD,"Buckler",1.0,0.0,0.17));
        shieldList.add(new Weapon(WeaponType.SHIELD,"Round Shield",1.0,2.0,0.15));
        shieldList.add(new Weapon(WeaponType.SHIELD,"Soldier's Shield",2.0,2.0,0.13));
        shieldList.add(new Weapon(WeaponType.SHIELD,"Sentinel's Shield",4.0,2.0,0.1));
        shieldList.add(new Weapon(WeaponType.SHIELD,"Tower Shield",3.0,4.0,0.08));
        shieldList.add(new Weapon(WeaponType.SHIELD,"Ancient Guardian",3.0,6.0,0.05));
        shieldList.add(new Weapon(WeaponType.SHIELD,"The Flameseeker Bastion",7.0,7.0,0.02));

        axeList.add(new Weapon(WeaponType.AXE,"Stone Axe",1.0,0.0,0.3));
        axeList.add(new Weapon(WeaponType.AXE,"Rusty Hatchet",1.0,0.0,0.17));
        axeList.add(new Weapon(WeaponType.AXE,"Iron Battleaxe",1.0,2.0,0.15));
        axeList.add(new Weapon(WeaponType.AXE,"Barbarian's Cleaver",2.0,2.0,0.13));
        axeList.add(new Weapon(WeaponType.AXE,"Viking's Fury",4.0,2.0,0.10));
        axeList.add(new Weapon(WeaponType.AXE,"Executioner's Axe",3.0,4.0,0.08));
        axeList.add(new Weapon(WeaponType.AXE,"Last Breath",3.0,6.0,0.05));
        axeList.add(new Weapon(WeaponType.AXE,"The Battleborn's Rending",7.0,7.0,0.02));

        pistolList.add(new Weapon(WeaponType.PISTOL,"Flintlock Pistol",1.0,0.0,0.3));
        pistolList.add(new Weapon(WeaponType.PISTOL,"Brass Revolver",1.0,0.0,0.17));
        pistolList.add(new Weapon(WeaponType.PISTOL,"Duelling Pistol",1.0,2.0,0.15));
        pistolList.add(new Weapon(WeaponType.PISTOL,"Engraved Pistol",2.0,2.0,0.13));
        pistolList.add(new Weapon(WeaponType.PISTOL,"Blunderbuss",4.0,2.0,0.10));
        pistolList.add(new Weapon(WeaponType.PISTOL,"Ivory Pistol",3.0,4.0,0.08));
        pistolList.add(new Weapon(WeaponType.PISTOL,"Monarch's Thunder",3.0,6.0,0.05));
        pistolList.add(new Weapon(WeaponType.PISTOL,"The H.O.P.E",7.0,7.0,0.02));

        weaponsList.add(swordList);
        weaponsList.add(shieldList);
        weaponsList.add(axeList);
        weaponsList.add(pistolList);
    }
}
