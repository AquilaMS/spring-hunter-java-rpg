package com.aquilamazzei.springhunter.resources;

import com.aquilamazzei.springhunter.dto.Fight.FightResult;
import com.aquilamazzei.springhunter.dto.Hero.OwnedByPlayerById;
import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.logics.Fight;
import com.aquilamazzei.springhunter.repositories.GreatHallRepository;
import com.aquilamazzei.springhunter.services.FightService;
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

    @Autowired
    private GreatHallRepository greatHallRepository;

    @Autowired
    private FightService fightService;

    @PostMapping
    public ResponseEntity fight(@RequestBody OwnedByPlayerById id){
        Hero attacker = heroService.getHeroesAliveByPlayerById(id);
        ResponseEntity fightResult2 = fightService.fight(attacker);
        Fight fight = new Fight();
        return ResponseEntity.ok(fightResult2);
    }
}
