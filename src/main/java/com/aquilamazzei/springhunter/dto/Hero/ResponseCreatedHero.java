package com.aquilamazzei.springhunter.dto.Hero;

import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.utils.enums.ClassNames;

public record ResponseCreatedHero(Long id, String peonName, Integer level, ClassNames classNames, Double damage, Double defense, Double life, Double experience, Boolean isAlive) {
}
