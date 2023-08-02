package com.aquilamazzei.springhunter.services;

import com.aquilamazzei.springhunter.entities.HeroClass;
import com.aquilamazzei.springhunter.repositories.HeroClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroClassService {

    @Autowired
    HeroClassRepository heroClassRepository;

    public void insertHeroClass(HeroClass heroClass){
        heroClassRepository.save(heroClass);
    }
}
