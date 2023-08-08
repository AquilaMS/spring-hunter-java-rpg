package com.aquilamazzei.springhunter.dto.Hero;

import com.aquilamazzei.springhunter.entities.HeroClass;
import com.aquilamazzei.springhunter.entities.Player;
import com.aquilamazzei.springhunter.utils.enums.ClassNames;

public record CreateHeroDTO(ClassNames className, String characterName) {
}
