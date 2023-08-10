package com.aquilamazzei.springhunter.services;

import com.aquilamazzei.springhunter.dto.Hero.CreateHeroDTO;
import com.aquilamazzei.springhunter.dto.Hero.OwnedByPlayerById;
import com.aquilamazzei.springhunter.dto.Hero.ResponseCreatedHero;
import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.HeroProfession;
import com.aquilamazzei.springhunter.entities.Player;
import com.aquilamazzei.springhunter.repositories.HeroRepository;
import com.aquilamazzei.springhunter.utils.security.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService {

    @Autowired
    HeroRepository heroRepository;

    @Autowired
    private AuthorizationService authorizationService;

    public ResponseCreatedHero insertHero(CreateHeroDTO createHeroDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Player loggedPlayer = (Player) authorizationService.loadUserByUsername(authentication.getName());
        HeroProfession newHeroProfession = new HeroProfession(createHeroDTO.className());
        Hero newHero = heroRepository.save(new Hero(loggedPlayer, newHeroProfession, createHeroDTO.characterName()));

        ResponseCreatedHero responseHero = new ResponseCreatedHero(
                newHero.getHeroProfession().getId(),
                newHero.getPeonName(),
                newHero.getLevel(),
                newHero.getHeroProfession().getClassName(),
                newHero.getDamage(),
                newHero.getDefense(),
                newHero.getLife(),
                newHero.getExperience(),
                newHero.getIsAlive()
        );

        return responseHero;
    }

    public List<ResponseCreatedHero> getAllHeroesAlive() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Player loggedPlayer = (Player) authorizationService.loadUserByUsername(authentication.getName());
        List<Hero> heroesGot = heroRepository.findAllByPlayer(loggedPlayer);
        List<ResponseCreatedHero> responseHero = new ArrayList<>();

        for (Hero hero : heroesGot) {
            if (hero.getIsAlive()) {
                responseHero.add(new ResponseCreatedHero(
                        hero.getHeroProfession().getId(),
                        hero.getPeonName(),
                        hero.getLevel(),
                        hero.getHeroProfession().getClassName(),
                        hero.getDamage(),
                        hero.getDefense(),
                        hero.getLife(),
                        hero.getExperience(),
                        true
                ));
            }
        }

        return responseHero;
    }

    public List<ResponseCreatedHero> getAllHeroesByLoggedPlayer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Player loggedPlayer = (Player) authorizationService.loadUserByUsername(authentication.getName());
        List<Hero> heroesGot = heroRepository.findAllByPlayer(loggedPlayer);

        List<ResponseCreatedHero> responseHero = new ArrayList<>();

        for (Hero hero : heroesGot) {
            responseHero.add(new ResponseCreatedHero(
                    hero.getHeroProfession().getId(),
                    hero.getPeonName(),
                    hero.getLevel(),
                    hero.getHeroProfession().getClassName(),
                    hero.getDamage(),
                    hero.getDefense(),
                    hero.getLife(),
                    hero.getExperience(),
                    hero.getIsAlive()
            ));

        }

        return responseHero;
    }

    public Hero getHeroesAliveByPlayerById(OwnedByPlayerById id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Player loggedPlayer = (Player) authorizationService.loadUserByUsername(authentication.getName());

        List<Hero> heroesGot = heroRepository.findAllByPlayer(loggedPlayer);
        List<Hero> heroesResponse = new ArrayList<>();

        for (Hero hero : heroesGot) {
            if (hero.getIsAlive()) {
                heroesResponse.add(hero);
            }
        }

        return heroesResponse.get(id.index());
    }

    public Hero updateHero(Hero newHero) {
        System.out.println(newHero);
        return heroRepository.save(newHero);
    }

    public void die(Hero hero) {
        hero.setIsAlive(false);
        heroRepository.save(hero);
    }
}
