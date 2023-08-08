package com.aquilamazzei.springhunter.services;

import com.aquilamazzei.springhunter.dto.Hero.CreateHeroDTO;
import com.aquilamazzei.springhunter.dto.Hero.OwnedByPlayerById;
import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.HeroClass;
import com.aquilamazzei.springhunter.entities.Player;
import com.aquilamazzei.springhunter.repositories.HeroRepository;
import com.aquilamazzei.springhunter.repositories.PlayerRepository;
import com.aquilamazzei.springhunter.utils.security.AuthorizationService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    @Autowired
    HeroRepository heroRepository;

    @Autowired
    private AuthorizationService authorizationService;

    public Hero insertHero(CreateHeroDTO createHeroDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Player loggedPlayer = (Player) authorizationService.loadUserByUsername(authentication.getName());
        HeroClass newHeroClass = new HeroClass(createHeroDTO.className());
        Hero newHero = new Hero(loggedPlayer, newHeroClass, createHeroDTO.characterName());

        heroRepository.save(newHero);
        return newHero;
    }

    public List<Hero> getAllHeroesByLoggedPlayer(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Player loggedPlayer = (Player) authorizationService.loadUserByUsername(authentication.getName());
        return heroRepository.findAllByPlayer(loggedPlayer);
    }

    public Hero getHeroOwnedByPlayerById(OwnedByPlayerById id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Player loggedPlayer = (Player) authorizationService.loadUserByUsername(authentication.getName());
        List<Hero> heroesGot = heroRepository.findAllByPlayer(loggedPlayer);

        return heroesGot.get(id.index());
    }

    public Hero updateHero(Hero newHero){
        return heroRepository.save(newHero);
    }
}
