package com.aquilamazzei.springhunter.services;

import com.aquilamazzei.springhunter.entities.Weapon;
import com.aquilamazzei.springhunter.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    public void insertWeapon(Weapon weapon){
        weaponRepository.save(weapon);
    }
}
