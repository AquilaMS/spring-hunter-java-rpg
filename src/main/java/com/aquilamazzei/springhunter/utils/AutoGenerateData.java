package com.aquilamazzei.springhunter.utils;


import com.aquilamazzei.springhunter.entities.*;
import com.aquilamazzei.springhunter.logics.Fight;
import com.aquilamazzei.springhunter.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutoGenerateData{

    @Autowired
    private WeaponService weapon;

    @Autowired
    private TypeService type;

    @Autowired
    private HeroClassService heroClass;

    @Autowired
    private HeroService hero;

    @Autowired
    private MonsterService monsterService;


    @EventListener(ApplicationReadyEvent.class)
    public void afterPropertiesSet(){
/*
        Player player = new Player("username", "123");
        Classes classes = new Classes();
        Hero hero1 = new Hero(player, classes.heroClassesList.get(0),"Barbariana");
        Fight.attack(hero1);
        Fight.attack(hero1);
        Fight.attack(hero1);
        Fight.attack(hero1);
        Fight.attack(hero1);

        List<Choices> choicesList = new ArrayList<>();

        for (int i=0; i<=3; i++){
            choicesList.add(new Choices());
        }

        System.out.println("ESCOLHA " + Choices.chosenOption(hero1, choicesList.get(0).getGeneratedOption()));

        System.out.println(choicesList);
        */
    }
}
