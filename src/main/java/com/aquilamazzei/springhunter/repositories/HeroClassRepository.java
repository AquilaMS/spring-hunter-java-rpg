package com.aquilamazzei.springhunter.repositories;

import com.aquilamazzei.springhunter.entities.HeroProfession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroClassRepository extends JpaRepository<HeroProfession, Long> {
}
