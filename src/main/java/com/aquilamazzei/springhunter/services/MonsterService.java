package com.aquilamazzei.springhunter.services;

import com.aquilamazzei.springhunter.entities.Monster;
import com.aquilamazzei.springhunter.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonsterService {

    @Autowired
    MonsterRepository monsterRepository;

    public void insertMonster(Monster monster){
        monsterRepository.save(monster);
    }
}
