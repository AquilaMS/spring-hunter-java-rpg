package com.aquilamazzei.springhunter.resources;

import com.aquilamazzei.springhunter.dto.Hero.OwnedByPlayerById;
import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.logics.Fight;
import com.aquilamazzei.springhunter.repositories.HeroRepository;
import com.aquilamazzei.springhunter.services.HeroClassService;
import com.aquilamazzei.springhunter.services.HeroService;
import com.aquilamazzei.springhunter.utils.security.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fight")
public class FightResource {

    @Autowired
    HeroService heroService;

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping
    public ResponseEntity fight(@RequestBody OwnedByPlayerById id){
        Hero attacker = heroService.getHeroOwnedByPlayerById(id);
        Hero updatedHero = Fight.attack(attacker);
        heroService.updateHero(updatedHero);
        return ResponseEntity.ok(updatedHero);
    }
}
