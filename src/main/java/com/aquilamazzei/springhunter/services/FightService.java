package com.aquilamazzei.springhunter.services;

import com.aquilamazzei.springhunter.dto.Fight.FightResult;
import com.aquilamazzei.springhunter.dto.User.ResponseToPlayer;
import com.aquilamazzei.springhunter.entities.GreatHall;
import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.logics.Fight;
import com.aquilamazzei.springhunter.repositories.GreatHallRepository;
import com.aquilamazzei.springhunter.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FightService {

    @Autowired
    private HeroService heroService;

    @Autowired
    private GreatHallRepository greatHallRepository;

    public ResponseEntity fight(Hero attacker){
        Fight fight = new Fight();
        FightResult fightResult = fight.attack(attacker);
        System.out.println("updated Hero" + fightResult.hero());

        attacker.setLife(fightResult.hero().life());
        attacker.setExperience(fightResult.hero().experience());
        attacker.setLevel(fightResult.hero().level());
        attacker.setDamage(fightResult.hero().damage());
        attacker.setWeapon(fightResult.weapon());
        attacker.setDefense(fightResult.hero().defense());

        //TODO: COLCOAR ISSO NO SERVICE
        if (fightResult.hero().life() > 0 && Objects.equals(fightResult.monster().getPeonName(), "The Deimos")){
            heroService.updateHero(attacker);
            GreatHall greatHall = new GreatHall(attacker);
            greatHallRepository.save(greatHall);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseToPlayer("You killed High Overlord Deimos, the Mallyx's general in this dimension. Your name and scars is now on the Great Hall's Stone Table!"));
        }

        if(fightResult.hero().life() <= 0){
            System.out.println("teste2 id: " + attacker.getHeroProfession().getId());
            heroService.die(attacker);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseToPlayer("The Death found you... This dimensions deserves The True Hero. Your name is now in the Oblivion and your scars is worthless"));
        }else {
            heroService.updateHero(attacker);
            return ResponseEntity.status(HttpStatus.OK).body(fightResult);
        }
    }
}
