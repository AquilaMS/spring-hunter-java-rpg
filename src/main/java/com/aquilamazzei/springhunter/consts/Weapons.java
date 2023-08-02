package com.aquilamazzei.springhunter.consts;

import java.util.ArrayList;
import java.util.List;

import com.aquilamazzei.springhunter.entities.Type;
import com.aquilamazzei.springhunter.entities.Weapon;
import org.springframework.stereotype.Service;

public class Weapons {

    public List<Weapon> weaponsList = new ArrayList<>();
    public List<Type> typeList = new ArrayList<>();

    public Weapons(){
        typeList.add(new Type("sword"));
        typeList.add(new Type("shield"));
        typeList.add(new Type("axe"));
        typeList.add(new Type("pistol"));

        weaponsList.add(new Weapon(typeList.get(0),"Wood Sword",1.0,0.0,1));
        weaponsList.add(new Weapon(typeList.get(0),"Improvised Sword",1.0,0.0,1));
        weaponsList.add(new Weapon(typeList.get(0),"Dull Blade",1.0,2.0,2));
        weaponsList.add(new Weapon(typeList.get(0),"Iron Sword",2.0,2.0,2));
        weaponsList.add(new Weapon(typeList.get(0),"Steel Sword",4.0,2.0,3));
        weaponsList.add(new Weapon(typeList.get(0),"Elite Sword",3.0,4.0,3));
        weaponsList.add(new Weapon(typeList.get(0),"Grandmaster's Sword",3.0,6.0,6));
        weaponsList.add(new Weapon(typeList.get(0),"The Sohothin",7.0,7.0,10));

        weaponsList.add(new Weapon(typeList.get(1),"Thorin's Shield",1.0,0.0,1));
        weaponsList.add(new Weapon(typeList.get(1),"Buckler",1.0,0.0,1));
        weaponsList.add(new Weapon(typeList.get(1),"Round Shield",1.0,2.0,2));
        weaponsList.add(new Weapon(typeList.get(1),"Soldier's Shield",2.0,2.0,2));
        weaponsList.add(new Weapon(typeList.get(1),"Sentinel's Shield",4.0,2.0,3));
        weaponsList.add(new Weapon(typeList.get(1),"Tower Shield",3.0,4.0,3));
        weaponsList.add(new Weapon(typeList.get(1),"Ancient Guardian",3.0,6.0,6));
        weaponsList.add(new Weapon(typeList.get(1),"The Flameseeker Bastion",7.0,7.0,10));

        weaponsList.add(new Weapon(typeList.get(2),"Stone Axe",1.0,0.0,1));
        weaponsList.add(new Weapon(typeList.get(2),"Rusty Hatchet",1.0,0.0,1));
        weaponsList.add(new Weapon(typeList.get(2),"Iron Battleaxe",1.0,2.0,2));
        weaponsList.add(new Weapon(typeList.get(2),"Barbarian's Cleaver",2.0,2.0,2));
        weaponsList.add(new Weapon(typeList.get(2),"Viking's Fury",4.0,2.0,3));
        weaponsList.add(new Weapon(typeList.get(2),"Executioner's Axe",3.0,4.0,3));
        weaponsList.add(new Weapon(typeList.get(2),"Last Breath",3.0,6.0,6));
        weaponsList.add(new Weapon(typeList.get(2),"The Battleborn's Rending",7.0,7.0,10));

        weaponsList.add(new Weapon(typeList.get(3),"Flintlock Pistol",1.0,0.0,1));
        weaponsList.add(new Weapon(typeList.get(3),"Brass Revolver",1.0,0.0,1));
        weaponsList.add(new Weapon(typeList.get(3),"Duelling Pistol",1.0,2.0,2));
        weaponsList.add(new Weapon(typeList.get(3),"Engraved Pistol",2.0,2.0,2));
        weaponsList.add(new Weapon(typeList.get(3),"Blunderbuss",4.0,2.0,3));
        weaponsList.add(new Weapon(typeList.get(3),"Ivory Pistol",3.0,4.0,3));
        weaponsList.add(new Weapon(typeList.get(3),"Monarch's Thunder",3.0,6.0,6));
        weaponsList.add(new Weapon(typeList.get(3),"The H.O.P.E",7.0,7.0,10));

    }

}
