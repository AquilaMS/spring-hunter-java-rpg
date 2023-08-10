package com.aquilamazzei.springhunter.dto.Fight;

import com.aquilamazzei.springhunter.dto.Hero.ResponseCreatedHero;
import com.aquilamazzei.springhunter.entities.Monster;
import com.aquilamazzei.springhunter.entities.Weapon;

public record FightResult(ResponseCreatedHero hero, Monster monster, Weapon weapon, Integer playerDiceSum, Integer monsterDiceSum) {
}
