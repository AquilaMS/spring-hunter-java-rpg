package com.aquilamazzei.springhunter.services;

import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

    @Autowired
    HeroRepository heroRepository;

    public void insertHero(Hero hero){
        heroRepository.save(hero);
    }
}
